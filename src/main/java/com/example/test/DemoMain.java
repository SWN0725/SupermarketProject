package com.example.test;

import java.math.BigDecimal;

public class DemoMain {
    public static void main(String[] args) {
        MySupermarket supermarket = new MySupermarket();
        ShoppingCard shoppingCard = new ShoppingCard(supermarket);

        /** 1. 正价销售苹果和草莓 **/
        // 超市出售苹果和草莓，且都是正价销售
        Fruit appleFruit = new Fruit("apple", "苹果", new BigDecimal("8"));
        Fruit strawberryFruit = new Fruit("strawberry", "草莓", new BigDecimal("13"));
        supermarket.updateFruitType(appleFruit.getType(), appleFruit);
        supermarket.updateFruitType(strawberryFruit.getType(), strawberryFruit);
        supermarket.setSupermarketSettle(new RegularSupermarketSettle());
        // 顾客A购买苹果和草莓
        shoppingCard.addToCard("apple", new BigDecimal("5.3"));
        shoppingCard.addToCard("strawberry", new BigDecimal("3.5"));
        // 订单结算
        try {
            System.out.println("正价销售苹果和草莓：" + shoppingCard.allCost());
        } catch (Exception e) {
            System.out.println("正价销售苹果和草莓：结算失败，" + e.getMessage());
        }

        /** 2. 超市增加芒果 **/
        Fruit mangoFruit = new Fruit("mango", "芒果", new BigDecimal("20"));
        supermarket.updateFruitType(mangoFruit.getType(), mangoFruit);
        // 顾客B苹果、草莓和芒果追加芒果
        shoppingCard.addToCard("apple", new BigDecimal("5.3"));
        shoppingCard.addToCard("strawberry", new BigDecimal("3.5"));
        shoppingCard.addToCard("mango", new BigDecimal("2"));

        // 订单结算
        try {
            System.out.println("超市增加芒果：" + shoppingCard.allCost());
        } catch (Exception e) {
            System.out.println("超市增加芒果：结算失败，" + e.getMessage());
        }

        /** 3. 促销活动 **/
        // 超市设置草莓打折
        DiscountSupermarketSettle discountSupermarketSettle = new DiscountSupermarketSettle();
        discountSupermarketSettle.updateDiscount(strawberryFruit.getType(), new BigDecimal("0.8"));
        supermarket.setSupermarketSettle(discountSupermarketSettle);
        // 订单结算
        try {
            System.out.println("促销活动：" + shoppingCard.allCost());
        } catch (Exception e) {
            System.out.println("促销活动：结算失败，" + e.getMessage());
        }

        /** 4. 满100减10 **/
        ReduceSupermarketSettle reduceSupermarketSettle = new ReduceSupermarketSettle(new BigDecimal("100"), new BigDecimal("10"), discountSupermarketSettle);
        supermarket.setSupermarketSettle(reduceSupermarketSettle);
        // 订单结算
        try {
            System.out.println("满100减10：" + shoppingCard.allCost());
        } catch (Exception e) {
            System.out.println("满100减10：结算失败，" + e.getMessage());
        }
    }
}
