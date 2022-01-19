package com.exadel.bootcamp;

import java.util.HashMap;

public class CashMachine {
    private static HashMap<Integer, Integer> banknotes = new HashMap<>();

    public static void setBanknotes(int billSize, int volume) {
        banknotes.put(billSize, volume);
    };

    public static HashMap getBanknotes() {
        return banknotes;
    }
}
