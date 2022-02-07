package com.exadel.bootcamp;

public class ClientAccount {
    private int availableCash = 1000;
    private String name;

    public ClientAccount(String name) {
        this.name = name;
    }

    public void setAvailableCashAdd(int cash) {
        this.availableCash += cash;
    }

    public void setAvailableCashRemove(int cash) {
        this.availableCash -= cash;
    }

    public String getName() {
        return this.name;
    }

    public int getAvailableCash() {
        return availableCash;
    }
}
