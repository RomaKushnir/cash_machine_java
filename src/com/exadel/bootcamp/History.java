package com.exadel.bootcamp;

import java.util.ArrayList;
import java.util.Collection;

public class History {
    public static Collection historyArr = new ArrayList();

    public static void setHistory(String historyInput) {
        historyArr.add(historyInput);
    }

    public static Collection getHistoryArr() {
        return historyArr;
    };
}
