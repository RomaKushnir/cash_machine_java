package com.exadel.bootcamp;

import java.util.*;

public class CashMachine {
    private String name;
    private SortedMap<Integer, Integer> banknotes = new TreeMap<>(Collections.reverseOrder());

    public CashMachine(String name) {
        this.name = name;
    }

    public void setBanknotes(int billSize, int quantity) {
        banknotes.put(billSize, quantity);
    };

    public String getName() {
        return this.name;
    }

    public void giveClientCash(int withdrawCash) {
        while (withdrawCash > 0) {
            for (Integer banknote : this.banknotes.keySet()) {
                if (withdrawCash >= banknote && this.banknotes.get(banknote) != 0) {
                    this.setBanknotes(banknote, this.banknotes.get(banknote) - 1);
                    withdrawCash -= banknote;
                    break;
                }
            }
        }
    }

    public Map<Integer, Integer> getBanknotes() {
        return banknotes;
    }

    public Integer getAllBanknotesSum() {
         return banknotes
                 .entrySet()
                 .stream()
                 .map(entry -> entry.getKey() * entry.getValue())
                 .reduce(0, Integer::sum);
    }
}
