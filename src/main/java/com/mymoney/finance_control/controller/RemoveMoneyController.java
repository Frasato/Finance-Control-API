package com.mymoney.finance_control.controller;

import com.mymoney.finance_control.dtos.RemoveRequestDto;
import com.mymoney.finance_control.models.RemoveMoney;
import com.mymoney.finance_control.models.User;
import com.mymoney.finance_control.repositories.UserRepository;
import com.mymoney.finance_control.services.RemoveMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/remove")
public class RemoveMoneyController {

    @Autowired
    private RemoveMoneyService removeMoneyService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> listAllRemovedMoney(){
        List<RemoveMoney> removeMoneyList = removeMoneyService.listAllRemovedMoney();

        if(removeMoneyList.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(removeMoneyList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listByUser(@PathVariable("id") String id){
        Optional<User> findedUser = userRepository.findById(id);

        if(findedUser.isEmpty()){
            return ResponseEntity.status(404).body("User not found or not authorized");
        }

        List<RemoveMoney> findedRemoveMoney = removeMoneyService.listAllByUserId(id);
        if(findedRemoveMoney.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(findedRemoveMoney);
    }

    @PostMapping("/takeout")
    public ResponseEntity<?> removeMoney(@RequestBody RemoveRequestDto removeRequestDto){
        Optional<User> findedUser = userRepository.findById(removeRequestDto.id());

        if(findedUser.isEmpty()){
            return ResponseEntity.status(404).body("User not found or not authorized");
        }

        User user = findedUser.get();
        RemoveMoney removeMoney = new RemoveMoney();

        removeMoney.setValue(removeRequestDto.value());
        removeMoney.setCategory(removeRequestDto.category());
        removeMoney.setForWhat(removeRequestDto.forWhat());
        removeMoney.setUserRemove(user);

        return ResponseEntity.status(201).body(removeMoney);

    }

}
