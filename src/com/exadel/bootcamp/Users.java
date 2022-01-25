package com.exadel.bootcamp;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private static Map<String, ClientAccount> users = new HashMap<>();

    public static void createUser(String login, ClientAccount user) {
        users.put(login, user);
    }

    public static Map<String, ClientAccount> getUsers() {
        return users;
    }

    public static void showUsers() {
        users.forEach((k, v) -> {
            System.out.println(k + " has available cash: " + v.showUserCash());
        });

//        for(Object entry: users.entrySet()) {
//            System.out.println("user " + entry);
//        }
    }
}
