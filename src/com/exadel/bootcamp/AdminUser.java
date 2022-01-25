package com.exadel.bootcamp;

public class AdminUser {
    public void put(CashMachine c, int billSize, int quantity) {
        c.setBanknotes(billSize, quantity);
    }
}
