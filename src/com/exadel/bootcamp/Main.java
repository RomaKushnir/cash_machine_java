package com.exadel.bootcamp;
import java.lang.String;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        try {
            System.out.println("Try to use this cash machine...");
            while (userInput.hasNextLine()){
                System.out.println("new loop");
                if (userInput.nextLine().equals("put")) {
                    int banknote;
                    int volume;

                    System.out.println("Enter banknote size:");
                    banknote = userInput.nextInt();
                    System.out.println("Enter volume:");
                    volume = userInput.nextInt();

                    CashMachine.setBanknotes(banknote, volume);
                    System.out.println("Money was successfully loaded");
                }

//                else if (userInput.nextLine().equals("give")) {
//
//                }

                else if (userInput.nextLine().equals("cache")) {
                    CashMachine.getBanknotes().forEach((k, v) -> System.out.println(k + " --- " + v));
                }

//                else if(userInput.nextLine().equals("stat")) {
//
//                }

                else if (userInput.nextLine().equals("quit")) {
                    userInput.close();
                }
            }

        }catch(Exception e){
            System.out.println("Error ::"+e.getMessage());
            e.printStackTrace();
        } finally {
            if (userInput != null)
                userInput.close();
        }
    }
}
