package com.mymoney.finance_control.services;

import com.mymoney.finance_control.models.RemoveMoney;
import com.mymoney.finance_control.repositories.RemoveMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoveMoneyService {

    @Autowired
    private RemoveMoneyRepository removeMoneyRepository;

    public List<RemoveMoney> listAllRemovedMoney(){
        return removeMoneyRepository.findAll();
    }

}
