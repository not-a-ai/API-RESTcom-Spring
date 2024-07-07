package me.dio.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity( name = "tb_user" )
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @Column(unique = true)
    String email;
    String password;

    @Column(precision = 2, scale = 13)
    BigDecimal balance;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();


    public void deposit(BigDecimal amount, String date) {
        this.balance = this.balance.add(amount);
        this.transactions.add(new Transaction(amount, date, "DEPOSIT", this));
    }

    public void withdraw(BigDecimal amount, String date) {
        this.balance = this.balance.subtract(amount);
        this.transactions.add(new Transaction(amount, date, "WITHDRAWAL", this));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
