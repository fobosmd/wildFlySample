package com.klystopad.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Kirill Listopad on 1/7/16.
 */
@Entity
@Table(name = "USER", uniqueConstraints = @UniqueConstraint(columnNames = "phone_number"))
public class User {

    @Id
    @Size(min = 1, max = 25)
    private String name;

    @NotNull
    private String password;

    @NotNull
    @Digits(fraction = 2, integer = 10)
    private BigDecimal balance;

    @NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12)
    @Column(name = "phone_number")
    private String phoneNumber;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<BalanceHistory> balanceHistories;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
