package com.mymoney.finance_control.controller;

import com.mymoney.finance_control.services.RemoveMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remove")
public class RemoveMoneyController {

    @Autowired
    private RemoveMoneyService removeMoneyService;


}
