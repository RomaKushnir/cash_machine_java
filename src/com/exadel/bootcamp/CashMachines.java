package com.exadel.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class CashMachines {
    private static List<CashMachine> cashMachinesList = new ArrayList<>();

    public static void addCashMachineToList(CashMachine c) {
        cashMachinesList.add(c);
    }

    public static CashMachine getCashMachine(String name) {
        return cashMachinesList.stream()
                .filter(el -> name.equals(el.getName()))
                .findFirst().orElse(null);
    }

    public static List getCashMachinesList() {
        return cashMachinesList;
    }
}
