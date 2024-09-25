package com.mymoney.finance_control.controllers;

import com.mymoney.finance_control.services.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/money")
public class MoneyControll {

    @Autowired
    private MoneyService moneyService;

    @GetMapping("/all")
    public ResponseEntity<?> allCost(){
        return ResponseEntity.status(200).body(moneyService.findAllCost());
    }

}
