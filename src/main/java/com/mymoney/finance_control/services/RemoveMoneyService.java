package com.mymoney.finance_control.services;

import com.mymoney.finance_control.repositories.RemoveMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveMoneyService {

    @Autowired
    private RemoveMoneyRepository removeMoneyRepository;

}
