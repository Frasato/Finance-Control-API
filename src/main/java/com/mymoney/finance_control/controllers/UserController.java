package com.mymoney.finance_control.controllers;

import com.mymoney.finance_control.dtos.MoneyDtoIn;
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

        UserModel newUser = userService.validateUser(user);
        if(newUser != null){
            return ResponseEntity.status(200).body(newUser);
        }else{
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }

}
