package com.example.test;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单结算
 */
public interface ISupermarketSettle {
    BigDecimal cost(List<SaleFruit> saleFruitList);
}
