package com.mymoney.finance_control.repositories;

import com.mymoney.finance_control.models.AddMoney;
import com.mymoney.finance_control.models.RemoveMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoveMoneyRepository extends JpaRepository<RemoveMoney, String> {

    @Query(value = "SELECT * FROM remove_money WHERE user_id=%:id%", nativeQuery = true)
    List<RemoveMoney> findByUserId(@Param("id") String id);
}
