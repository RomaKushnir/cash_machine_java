package com.exadel.bootcamp;

import java.util.Scanner;

public class CommandExecutor {
    public static void runEntryPoint() {
        System.out.println("Welcome, enter you name");
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNextLine()){
                String command = scanner.nextLine();
                if (command.equals("quit")) {
                    scanner.close();
                    return;
                }
                else if (command.equals("admin")) {
                    runAdmin(scanner);
                } else {
                    runClient(scanner, command);
                }
            }
        } catch(Exception e){
            System.out.println("Error ::"+e.getMessage());
            e.printStackTrace();
        }
    }
    private static void runAdmin(Scanner scanner) {
        AdminUser admin = new AdminUser();
        System.out.println("What are you going to do..?");
        try {
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                if (command.equals("home")) {
                    runEntryPoint();
                } else if (command.equals("put")) {
                    System.out.println("Give a name to cash machine");
                    String cashMachineName = scanner.nextLine();
                    CashMachine c = CashMachines.getCashMachine(cashMachineName);
                    if (c == null) {
                        c = new CashMachine(cashMachineName);
                    }
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
                    System.out.println("Name cash machine you want to check cash amount");
                    CashMachine currentCashMachine = CashMachines.getCashMachine(scanner.nextLine());
                    currentCashMachine.setBanknotes(10, 1000);
                    System.out.println("Available cash:");
                    currentCashMachine.getBanknotes().forEach((k, v) -> {
                        System.out.println(k + " size - " + v + " quantity");
                    });
                    History.setHistory("checkout cash");
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
                    History.setHistory("checkout users list");
                } else if (command.equals("cash")) {
                    System.out.println("What name of cash machine?");
                    CashMachines.getCashMachine(scanner.nextLine()).getAllBanknotesSum();
                }
            }
         } catch(Exception e){
            System.out.println("Error ::"+e.getMessage());
            e.printStackTrace();
        }
    }

    private static void runClient(Scanner scanner, String user) {
        if (!Users.getUsers().containsKey(user)) {
            Users.createUser(user, new ClientAccount(user));
        }
        ClientAccount userAccount = Users.getUsers().get(user);

        try {
            System.out.println("Welcome... type command...");
            while (scanner.hasNextLine()){
                String userInput = scanner.nextLine();
                if (userInput.equals("home")) {
                    runEntryPoint();
                } else if (userInput.equals("put")) {
                    System.out.println("Enter cash amount you want to put");
                    int cash = scanner.nextInt();
                    userAccount.setAvailableCashAdd(cash);
                    System.out.println("Money was successfully loaded");
                    System.out.println("What are you going to do next?");
                }

                else if (userInput.equals("give")) {
                    System.out.println("Enter cash machine name...");
                    CashMachine currentCashMachine = CashMachines.getCashMachine(scanner.nextLine());
                    System.out.println("What sum do you want to withdraw?");
                    int userWithdrawSum = scanner.nextInt();
                    //use for testing
//                    currentCashMachine.giveClientCash(userWithdrawSum);
                    if (userAccount.getAvailableCash() < userWithdrawSum) {
                        System.out.println("You have no such amount on your account");
                    }
                    if (currentCashMachine.getAllBanknotesSum() < userWithdrawSum) {
                        System.out.println("There are no such sum available to give");
                        int safeWithdraw = currentCashMachine.getAllBanknotesSum()/2;
                        System.out.println("Do you want to withdraw " + safeWithdraw + " Y/N?");
                        Scanner scanner1 = new Scanner(System.in);
                        if (scanner1.nextLine().equals("Y")) {
                            currentCashMachine.giveClientCash(safeWithdraw);
                            userAccount.setAvailableCashRemove(safeWithdraw);
                            System.out.println("Money are successfully withdrawn");
                        } else {
                            runEntryPoint();
                        }

                    } else {
                        currentCashMachine.giveClientCash(userWithdrawSum);
                        userAccount.setAvailableCashRemove(userWithdrawSum);
                        System.out.println("Money are successfully withdrawn");
                        runEntryPoint();
                    }
                }

                else if (userInput.equals("cache")) {
                    System.out.println("available cash is: " + userAccount.getAvailableCash());
                }


                else if (userInput.equals("quit")) {
                    scanner.close();
                    return;
                }
            }

        }catch(Exception e){
            System.out.println("Error ::"+e.getMessage());
            e.printStackTrace();
        }
    }
}
