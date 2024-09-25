package com.mymoney.finance_control.repositories;

import com.mymoney.finance_control.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    @Query(value = "SELECT FROM user_tb WHERE username=:username", nativeQuery = true)
    Optional<UserModel> findUserByUsername(@Param("username") String username);

}
