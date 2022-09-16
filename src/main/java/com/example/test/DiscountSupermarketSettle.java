package com.example.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 折价销售订单结算
 */
public class DiscountSupermarketSettle implements ISupermarketSettle {
    private Map<String, BigDecimal> fruitDiscountMap;

    public DiscountSupermarketSettle() {
        this.fruitDiscountMap = new HashMap<String, BigDecimal>();
    }

    public void updateDiscount(String type, BigDecimal discount) {
        this.fruitDiscountMap.put(type, discount);
    }

    public BigDecimal cost(List<SaleFruit> saleFruitList) {
        BigDecimal allPrice = new BigDecimal("0");
        for (SaleFruit saleFruit : saleFruitList) {
            Fruit fruit = saleFruit.getFruit();
            // 计算正价金额
            BigDecimal price = saleFruit.getCount().multiply(fruit.getPrice());
            // 计算折扣后的价格
            BigDecimal discount = this.fruitDiscountMap.get(fruit.getType());
            if (discount != null) {
                price = price.multiply(discount);
            }
            // 添加到总金额
            allPrice = allPrice.add(price);
        }
        return allPrice;
    }
}
