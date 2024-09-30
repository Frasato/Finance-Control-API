package com.mymoney.finance_control.repositories;

import com.mymoney.finance_control.models.AddMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddMoneyRepository extends JpaRepository<AddMoney, String> {}
