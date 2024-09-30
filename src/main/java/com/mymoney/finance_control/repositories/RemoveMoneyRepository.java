package com.mymoney.finance_control.repositories;

import com.mymoney.finance_control.models.RemoveMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemoveMoneyRepository extends JpaRepository<RemoveMoney, String> {}
