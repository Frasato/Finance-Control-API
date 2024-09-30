package com.mymoney.finance_control.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "remove_money")
public class RemoveMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double value;
    private String forWhat;
    private String category;
    private Instant removeDate;

    public RemoveMoney() {
    }

    public RemoveMoney(String id, Double value, String forWhat, String category, Instant removeDate) {
        this.id = id;
        this.value = value;
        this.forWhat = forWhat;
        this.category = category;
        this.removeDate = removeDate;
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

    public Instant getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Instant removeDate) {
        this.removeDate = removeDate;
    }

    @PrePersist
    private void setRemoveDateMoney(){
        this.removeDate = LocalDateTime
                .now().toInstant(ZoneOffset
                        .of("-03:00"));
    }
}
