package com.mymoney.finance_control.controller;

import com.mymoney.finance_control.models.AddMoney;
import com.mymoney.finance_control.models.RemoveMoney;
import com.mymoney.finance_control.services.AddMoneyService;
import com.mymoney.finance_control.services.RemoveMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sum")
public class SumController {

    @Autowired
    private AddMoneyService addMoneyService;
    @Autowired
    private RemoveMoneyService removeMoneyService;

    @GetMapping
    public ResponseEntity<?> sumPositiveMoney(){
        List<AddMoney> allAddMoney = addMoneyService.listAll();
        double totalValue = 0;

        if(!allAddMoney.isEmpty()){
            for (AddMoney addMoney : allAddMoney) {
                totalValue = totalValue + addMoney.getValue();
            }

            return ResponseEntity.status(200).body(totalValue);
        }else{
            return ResponseEntity.status(200).body(0);
        }
    }

    @GetMapping("/outs")
    public ResponseEntity<?> sumNegativeMoney(){
        List<RemoveMoney> allRemovedMoney = removeMoneyService.listAllRemovedMoney();
        double totalValue = 0;

        if(!allRemovedMoney.isEmpty()){
            for(int i = 0; i < allRemovedMoney.size(); i++){
                totalValue = totalValue + allRemovedMoney.get(i).getValue();
            }

            return ResponseEntity.status(200).body(totalValue);
        }else{
            return ResponseEntity.status(200).body(0);
        }
    }

}
