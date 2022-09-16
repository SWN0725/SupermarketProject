package com.example.test;

import java.math.BigDecimal;
import java.util.List;

/**
 * 满减订单结算
 */
public class ReduceSupermarketSettle implements ISupermarketSettle {
    // 基本计算
    ISupermarketSettle supermarketSettle;
    // 达到金额
    private BigDecimal reachAmount;
    // 减少金额
    private BigDecimal reduceAmount;

    public ReduceSupermarketSettle(BigDecimal reachAmount, BigDecimal reduceAmount, ISupermarketSettle supermarketSettle) {
        this.reachAmount = reachAmount;
        this.reduceAmount = reduceAmount;
        this.supermarketSettle = supermarketSettle;
    }

    public BigDecimal cost(List<SaleFruit> saleFruitList) {
        BigDecimal allPrice = supermarketSettle.cost(saleFruitList);
        // 满减
        if (allPrice.compareTo(this.reachAmount) >= 0) {
            allPrice = allPrice.subtract(this.reduceAmount);
        }
        return allPrice;
    }
}
