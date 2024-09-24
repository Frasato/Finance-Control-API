package com.mymoney.finance_control.repositories;

import com.mymoney.finance_control.models.MoneyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface MoneyRepository extends JpaRepository<MoneyModel, UUID> {
}
