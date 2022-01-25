package com.exadel.bootcamp;

import java.util.HashMap;
import java.util.Map;

public class CashMachine {
    private String name;
    private Map<Integer, Integer> banknotes = new HashMap<>();

    public CashMachine(String name) {
        this.name = name;
    }

    public void setBanknotes(int billSize, int quantity) {
        banknotes.put(billSize, quantity);
    };

    public String getName() {
        return this.name;
    }

    public Map getBanknotes() {
        return banknotes;
    }


}
