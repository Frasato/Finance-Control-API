package com.mymoney.finance_control.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_tb")
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

    public UserModel() {
    }

    public UserModel(UUID id, String username, String password, List<MoneyModel> moneyModelList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.moneyModelList = moneyModelList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MoneyModel> getMoneyModelList() {
        return moneyModelList;
    }

    public void setMoneyModelList(List<MoneyModel> moneyModelList) {
        this.moneyModelList = moneyModelList;
    }
}
