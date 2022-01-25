package com.exadel.bootcamp;

public class ClientAccount {
    private int availableCash = 1000;
    private String name;

    public ClientAccount(String name) {
        this.name = name;
    }

    public void put(CashMachine c, int cash) {
        System.out.println("cash machine " + c + "user cash " + cash);
    }

    public int showUserCash() {
        return availableCash;
    }
}
