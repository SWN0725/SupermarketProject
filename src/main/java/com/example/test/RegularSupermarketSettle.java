package com.example.test;

import java.math.BigDecimal;
import java.util.List;

/**
 * 正价销售订单结算
 */
public class RegularSupermarketSettle implements ISupermarketSettle {

    public BigDecimal cost(List<SaleFruit> saleFruitList) {
        BigDecimal allPrice = new BigDecimal("0");
        for (SaleFruit saleFruit : saleFruitList) {
            Fruit fruit = saleFruit.getFruit();
            BigDecimal price = saleFruit.getCount().multiply(fruit.getPrice());
            allPrice = allPrice.add(price);
        }
        return allPrice;
    }
}
