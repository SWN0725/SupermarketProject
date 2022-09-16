package com.example.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCard {
    private AbstractSupermarket supermarket;
    List<SaleFruit> saleFruitList;

    public ShoppingCard(AbstractSupermarket supermarket) {
        this.supermarket = supermarket;
        this.saleFruitList = new ArrayList<SaleFruit>();
    }

    /**
     * 添加到购物车
     * @param type
     * @param count
     */
    public void addToCard(String type, BigDecimal count) {
        Fruit fruit = this.supermarket.getFruit(type);
        SaleFruit saleFruit = new SaleFruit(fruit, count);
        this.saleFruitList.add(saleFruit);
    }

    public BigDecimal allCost() throws Exception {
        return supermarket.allCost(this.saleFruitList);
    }
}
