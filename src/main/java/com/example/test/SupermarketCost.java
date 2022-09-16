package com.example.test;

import java.math.BigDecimal;
import java.util.List;

public interface SupermarketCost {
    BigDecimal allCostR(List<SaleFruit> saleFruitList);
    BigDecimal allCostD(List<SaleFruit> saleFruitList);
    BigDecimal allCostDF(List<SaleFruit> saleFruitList);
}
