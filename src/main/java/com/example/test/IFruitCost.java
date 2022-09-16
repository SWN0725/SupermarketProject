package com.example.test;

import java.math.BigDecimal;

public interface IFruitCost {
    BigDecimal cost(BigDecimal price, BigDecimal count);
}
