package com.mymoney.finance_control.services;

import com.mymoney.finance_control.models.MoneyModel;
import com.mymoney.finance_control.repositories.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyService {

    @Autowired
    private MoneyRepository moneyRepository;

    public void saveMoneyIn(MoneyModel moneyModel){
        moneyRepository.save(moneyModel);
    }

    public List<MoneyModel> findAllCost(){
        return moneyRepository.findAll();
    }

}
