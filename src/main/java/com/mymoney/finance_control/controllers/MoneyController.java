package com.mymoney.finance_control.controllers;

import com.mymoney.finance_control.dtos.MoneyDtoIn;
import com.mymoney.finance_control.dtos.MoneyDtoOut;
import com.mymoney.finance_control.models.MoneyModel;
import com.mymoney.finance_control.models.UserModel;
import com.mymoney.finance_control.services.MoneyService;
import com.mymoney.finance_control.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> allCost(){
        return ResponseEntity.status(200).body(moneyService.findAllCost());
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addMoneyOnAccount(@PathVariable("userId") UUID userId, @RequestBody MoneyDtoIn moneyDto){
        Optional<UserModel> findedUser = userService.findUserById(userId);

        MoneyModel money = new MoneyModel();

        if(findedUser.isPresent()){
            UserModel user = findedUser.get();

            money.setMoneyOut(0.0);
            money.setMoneyIn(moneyDto.getMoneyIn());
            money.setForWhat(moneyDto.getForWhat());
            money.setCategory(moneyDto.getCategory());
            money.setUserId(user);

            moneyService.saveMoneyIn(money);
            return ResponseEntity.status(201).body(money);
        }else{
            return ResponseEntity.status(404).body("User not found to save a money!");
        }
    }

    @PostMapping("/out/{userId}")
    public ResponseEntity<?> outMoneyOnAccount(@PathVariable("userId") UUID userId, @RequestBody MoneyDtoOut moneyDtoOut){
        Optional<UserModel> findedUser = userService.findUserById(userId);
        MoneyModel money = new MoneyModel();

        if(findedUser.isPresent()){
            UserModel user = findedUser.get();

            money.setMoneyIn(0.0);
            money.setMoneyOut(moneyDtoOut.getMoneyOut());
            money.setForWhat(moneyDtoOut.getForWhat());
            money.setCategory(moneyDtoOut.getCategory());
            money.setUserId(user);

            moneyService.saveMoneyIn(money);
            return ResponseEntity.status(201).body(money);
        }else{
            return ResponseEntity.status(400).body("Error on add a take out money function");
        }
    }
}
