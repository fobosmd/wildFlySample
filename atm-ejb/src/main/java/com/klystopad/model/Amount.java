package com.klystopad.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by Kirill Listopad on 1/7/16.
 */
public class Amount {

    @NotNull
    @Digits(fraction = 2, integer = 10)
    @Min(1)
    private BigDecimal amount;

    public Amount() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
