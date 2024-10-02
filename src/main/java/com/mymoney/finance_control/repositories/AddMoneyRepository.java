package com.mymoney.finance_control.repositories;

import com.mymoney.finance_control.models.AddMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddMoneyRepository extends JpaRepository<AddMoney, String> {

    @Query(value = "SELECT * FROM add_money WHERE user_id=%:id%", nativeQuery = true)
    List<AddMoney> findByUserId(@Param("id") String id);
}
