package com.example.test;

import java.util.HashMap;
import java.util.Map;

public class MySupermarket extends AbstractSupermarket {
    private Map<String, Fruit> fruitMap;

    public MySupermarket() {
        this.fruitMap = new HashMap<String, Fruit>();
    }

    public void updateFruitType(String type, Fruit fruit) {
        this.fruitMap.put(type, fruit);
    }

    @Override
    Fruit getFruit(String type) {
        return fruitMap.get(type);
    }
}
