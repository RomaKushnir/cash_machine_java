package com.exadel.bootcamp;
import java.lang.String;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Type commands to use this cash machine...");
            while (scanner.hasNextLine()){
                String userInput = scanner.nextLine();
                if (userInput.equals("put")) {
                    int banknote;
                    int quantity;

                    System.out.println("Enter banknote size:");
                    banknote = scanner.nextInt();
                    System.out.println("Enter quantity:");
                    quantity = scanner.nextInt();

                    CashSlots.setBanknotes(banknote, quantity);
                    History.setHistory("put cash: " + banknote + " size - " + quantity + " quantity");
                    System.out.println("Money was successfully loaded");
                }

//                else if (userInput.nextLine().equals("give")) {
//
//                }

                else if (userInput.equals("cache")) {
                    System.out.println("Available cash:");
                    CashSlots.getBanknotes().forEach((k, v) -> {
                        System.out.println(k + " size - " + v + " quantity");
                    });
                    History.setHistory("checkout cash");
                }

                else if(userInput.equals("stat")) {
                    for (Object element : History.getHistoryArr()) {
                        System.out.println(element);
                    }
                    History.setHistory("checkout stats");
                }

                else if (userInput.equals("quit")) {
                    scanner.close();
                }
            }

        }catch(Exception e){
            System.out.println("Error ::"+e.getMessage());
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }
}
