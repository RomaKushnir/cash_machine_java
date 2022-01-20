package com.exadel.bootcamp;

import java.util.HashMap;

public class CashSlots {
    private static HashMap<Integer, Integer> banknotes = new HashMap<>();

    public static void setBanknotes(int billSize, int quantity) {
        banknotes.put(billSize, quantity);
    };

    public static HashMap getBanknotes() {
        return banknotes;
    }
}
