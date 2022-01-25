package com.exadel.bootcamp;
import java.lang.String;


public class Main {

    public static void main(String[] args) {
        ClientAccount testUser1 = new ClientAccount("Ivan");
        ClientAccount testUser2 = new ClientAccount("Petro");
        Users.createUser("ivan", testUser1);
        Users.createUser("petro", testUser2);
        CommandExecutor.identifyUser();
    }
}
