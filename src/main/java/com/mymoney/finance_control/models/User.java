package com.mymoney.finance_control.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "userAdd", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<AddMoney> addMoney;

    @OneToMany(mappedBy = "userRemove", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RemoveMoney> removeMoney;

    public User() {
    }

    public User(String id, String username, String email, String password, List<AddMoney> addMoney, List<RemoveMoney> removeMoney) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.addMoney = addMoney;
        this.removeMoney = removeMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AddMoney> getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(List<AddMoney> addMoney) {
        this.addMoney = addMoney;
    }

    public List<RemoveMoney> getRemoveMoney() {
        return removeMoney;
    }

    public void setRemoveMoney(List<RemoveMoney> removeMoney) {
        this.removeMoney = removeMoney;
    }
}
