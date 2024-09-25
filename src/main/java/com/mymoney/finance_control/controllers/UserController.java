package com.mymoney.finance_control.controllers;

import com.mymoney.finance_control.dtos.MoneyDto;
import com.mymoney.finance_control.dtos.UserDto;
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
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MoneyService moneyService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){

        UserModel user = new UserModel();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        try{
            userService.registerUser(user);
            return ResponseEntity.status(200).body(user);
        }catch (Exception exception){
            return ResponseEntity.status(400).body("Error registering user: " + exception);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto){
        UserModel user = new UserModel();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        if(userService.validateUser(user)){
            return ResponseEntity.status(200).body(user);
        }else{
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addMoneyOnAccount(@PathVariable("userId")UUID userId, @RequestBody MoneyDto moneyDto){
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

}
