package com.example.test;

import java.math.BigDecimal;
import java.util.List;

public abstract class AbstractSupermarket {
    private ISupermarketSettle supermarketSettle;

    public void setSupermarketSettle(ISupermarketSettle supermarketSettle) {
        this.supermarketSettle = supermarketSettle;
    }

    /**
     * 结算金额
     * @param saleFruitList
     * @return
     * @throws Exception
     */
    public BigDecimal allCost(List<SaleFruit> saleFruitList) throws Exception {
        if (supermarketSettle == null) {
            throw new Exception("未设置结算规则");
        }
        return supermarketSettle.cost(saleFruitList);
    }

    /**
     * 根据类型获取水果
     * @param type
     * @return
     */
    abstract Fruit getFruit(String type);
}
