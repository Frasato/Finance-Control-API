package com.mymoney.finance_control.services;

import com.mymoney.finance_control.models.AddMoney;
import com.mymoney.finance_control.repositories.AddMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddMoneyService {

    @Autowired
    private AddMoneyRepository addMoneyRepository;

    public List<AddMoney> listAll(){
        return addMoneyRepository.findAll();
    }

    public void save(AddMoney addMoney){
        addMoneyRepository.save(addMoney);
    }

    public List<AddMoney> listByUser(String id){
        return addMoneyRepository.findByUserId(id);
    }

}
