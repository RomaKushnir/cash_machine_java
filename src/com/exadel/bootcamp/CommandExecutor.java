package com.exadel.bootcamp;

import java.util.Scanner;

public class CommandExecutor {
    public static void identifyUser() {
        System.out.println("Welcome, enter you name");
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNextLine()){
                String command = scanner.nextLine();
                if (command.equals("quit")) {
                    scanner.close();
                }
                else if (command.equals("admin")) {
                    runAdmin();
                } else {
                    runClient();
                }

                System.out.println("command set: " + command);
            }
        } catch(Exception e){
            System.out.println("Error ::"+e.getMessage());
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

//    public static void identifyUser() {
//        System.out.println("Enter you name");
//        Scanner scanner = new Scanner(System.in);
//        String inputValue = scanner.nextLine();
//        System.out.println("value from console: " + inputValue);
//
//        if (inputValue.equals("admin")) {
//            AdminUser admin = new AdminUser();
//            System.out.println("Give a name to cash machine");
//            Scanner adminScanner = new Scanner(System.in);
//            String adminCommand = adminScanner.nextLine();
//
//            CashMachine c = new CashMachine("c1");
//
//            if (inputValue.equals("put")) {
//                int banknote;
//                int quantity;
//
//                System.out.println("Enter banknote size:");
//                banknote = Integer.parseInt(inputValue);
//                System.out.println("Enter quantity:");
//                quantity = Integer.parseInt(inputValue);
//
//                admin.put(c, banknote, quantity);
//                History.setHistory("put cash: " + banknote + " size - " + quantity + " quantity");
//                System.out.println("Money was successfully loaded");
//            } else if (inputValue.equals("home")) {
//                identifyUser();
//            }
//        }
//
//        if (!Users.getUsers().keySet().contains(inputValue)) {
//            Users.createUser(inputValue, new ClientAccount(inputValue));
//        }
//    }

    public static void runAdmin() {
        AdminUser admin = new AdminUser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What are you going to do...");
        try {
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                if (command.equals("exit")) {
                    identifyUser();
                } else if (command.equals("put")) {
                    System.out.println("Give a name to cash machine");
                    CashMachine c = new CashMachine(scanner.nextLine());
                    System.out.println("Enter banknote size:");
                    int banknote = scanner.nextInt();
                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    admin.put(c, banknote, quantity);
                    CashMachines.addCashMachineToList(c);
                    History.setHistory("put cash: " + banknote + " size - " + quantity + " quantity");
                    System.out.println("Money was successfully loaded");
                    System.out.println("Choose next what to do");
                } else if (command.equals("cache")) {
                    //                System.out.println("Available cash:");
                    //                CashMachine.getBanknotes().forEach((k, v) -> {
                    //                    System.out.println(k + " size - " + v + " quantity");
                    //                });
                    //                History.setHistory("checkout cash");
                } else if (command.equals("stat")) {
                    for (Object element : CashMachines.getCashMachinesList()) {
                        System.out.println("CashMachines: "+ element);
                    }
                    for (Object element : History.getHistoryArr()) {
                        System.out.println(element);
                    }
                    History.setHistory("checkout stats");
                } else if (command.equals("users")) {
                    Users.showUsers();
                }
            }
         } catch(Exception e){
            System.out.println("Error ::"+e.getMessage());
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

    public static void runClient() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Welcome...");
            while (scanner.hasNextLine()){
                String userInput = scanner.nextLine();
                if (userInput.equals("put")) {
//                    int banknote;
//                    int quantity;
//
//                    System.out.println("Enter banknote size:");
//                    banknote = scanner.nextInt();
//                    System.out.println("Enter quantity:");
//                    quantity = scanner.nextInt();
//
//                    CashMachine.setBanknotes(banknote, quantity);
//                    History.setHistory("put cash: " + banknote + " size - " + quantity + " quantity");
//                    System.out.println("Money was successfully loaded");
                }

//                else if (userInput.equals("give")) {
//                    for (Object entry: CashMachine.getBanknotes().entrySet()) {
//                        System.out.println(entry);
//                    }
//                }

//                else if (userInput.equals("cache")) {
//                    System.out.println("Available cash:");
//                    CashMachine.getBanknotes().forEach((k, v) -> {
//                        System.out.println(k + " size - " + v + " quantity");
//                    });
//                    System.out.println();
//                    History.setHistory("checkout cash");
//                }

//        if (!Users.getUsers().keySet().contains(inputValue)) {
//            Users.createUser(inputValue, new ClientAccount(inputValue));
//        }
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
