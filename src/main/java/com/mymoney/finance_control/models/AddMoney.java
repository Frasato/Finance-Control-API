package com.mymoney.finance_control.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "add_money")
public class AddMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double value;
    private String context;
    private Instant addDate;

    public AddMoney() {
    }

    public AddMoney(String id, Double value, String context, Instant addDate) {
        this.id = id;
        this.value = value;
        this.context = context;
        this.addDate = addDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Instant getAddDate() {
        return addDate;
    }

    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }

    @PrePersist
    private void setTheAddDateAndTime(){
        this.addDate = LocalDateTime
                .now()
                .toInstant(ZoneOffset
                        .of("-03:00"));
    }
}
