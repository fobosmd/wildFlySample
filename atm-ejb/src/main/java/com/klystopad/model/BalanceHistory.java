package com.klystopad.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Kirill Listopad on 1/9/16.
 */
@Entity
@Table(name = "BALANCE_HISTORY")
public class BalanceHistory {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "user_name", referencedColumnName = "name")
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Digits(fraction = 2, integer = 10)
    private BigDecimal amount;

    @NotNull
    private LocalDateTime operationDateTime;

    public BalanceHistory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getOperationDateTime() {
        return operationDateTime;
    }

    public void setOperationDateTime(LocalDateTime operationDateTime) {
        this.operationDateTime = operationDateTime;
    }
}
