package com.example.test;

import java.math.BigDecimal;

public class DiscountFruitCost implements IFruitCost {
    private BigDecimal discount;

    public DiscountFruitCost(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal cost(BigDecimal price, BigDecimal count) {
        return price.multiply(count).multiply(this.discount);
    }
}
