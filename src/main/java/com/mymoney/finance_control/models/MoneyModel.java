package com.mymoney.finance_control.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "money_tb")
public class MoneyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "money_id")
    private UUID moneyId;

    @Column(name = "money_out")
    private Double moneyOut;

    @Column(name = "money_in")
    private Double moneyIn;

    @Column(name = "for_what")
    private String forWhat;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserModel userId;

    public MoneyModel() {
    }

    public MoneyModel(UUID moneyId, Double moneyOut, Double moneyIn, String forWhat, String category, UserModel userId) {
        this.moneyId = moneyId;
        this.moneyOut = moneyOut;
        this.moneyIn = moneyIn;
        this.forWhat = forWhat;
        this.category = category;
        this.userId = userId;
    }

    public UUID getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(UUID moneyId) {
        this.moneyId = moneyId;
    }

    public Double getMoneyOut() {
        return moneyOut;
    }

    public void setMoneyOut(Double moneyOut) {
        this.moneyOut = moneyOut;
    }

    public Double getMoneyIn() {
        return moneyIn;
    }

    public void setMoneyIn(Double moneyIn) {
        this.moneyIn = moneyIn;
    }

    public String getForWhat() {
        return forWhat;
    }

    public void setForWhat(String forWhat) {
        this.forWhat = forWhat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UserModel getUserId() {
        return userId;
    }

    public void setUserId(UserModel userId) {
        this.userId = userId;
    }
}
