package com.mymoney.finance_control.dtos;

public class MoneyDtoIn {

    private Double moneyIn;
    private String forWhat;
    private String category;

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
}
