package com.mymoney.finance_control.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_tb")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MoneyModel> moneyModelList;

}
