package com.exadel.bootcamp;

import java.util.ArrayList;

public class CashMachines {
    private static ArrayList<CashMachine> cashMachinesList = new ArrayList<>();

    public static void addCashMachineToList(CashMachine c) {
        cashMachinesList.add(c);
    }

    public static CashMachine getCashMachine(String name) {
        CashMachine c = cashMachinesList.stream()
                .filter(el -> name.equals(el.getName()))
                .findFirst().orElse(null);
        return c;
    }

    public static ArrayList getCashMachinesList() {
        return cashMachinesList;
    }
}
