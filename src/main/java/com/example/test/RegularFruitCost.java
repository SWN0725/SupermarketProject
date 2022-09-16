package com.example.test;

import java.math.BigDecimal;

public class RegularFruitCost implements IFruitCost {
    public BigDecimal cost(BigDecimal price, BigDecimal count) {
        return price.multiply(count);
    }
}
