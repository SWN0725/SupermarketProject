package com.example.test;

import java.math.BigDecimal;

public class SaleFruit {
    private Fruit fruit;
    private BigDecimal count;

    public SaleFruit(Fruit fruit, BigDecimal count) {
        this.fruit = fruit;
        this.count = count;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public BigDecimal getCount() {
        return count;
    }
}
