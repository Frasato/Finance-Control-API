package com.mymoney.finance_control.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "money_tb")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

}
