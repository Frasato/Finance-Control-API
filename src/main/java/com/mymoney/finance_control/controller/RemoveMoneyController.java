package com.mymoney.finance_control.controller;

import com.mymoney.finance_control.models.RemoveMoney;
import com.mymoney.finance_control.repositories.UserRepository;
import com.mymoney.finance_control.services.RemoveMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
