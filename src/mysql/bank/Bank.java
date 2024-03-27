package mysql.bank;

import java.util.Scanner;

public class Bank {
    private Account account;
    private Scanner scanner;

    public Bank() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice = 0;
        do {
            choice = loginMenu();
            switch (choice) {
                case 1:
                    if(login()) {
                        int option = 0;
                        do {
                            option = userMenu();
                            switch(option) {
                                case 1:
                                    System.out.println("BALANCE: " + account.getBalance());
                                    break;
                                case 2:
                                    System.out.print("Amount: ");
                                    int amount = scanner.nextInt();
                                    if(!account.withdraw(amount)) {
                                        System.out.println("Withdraw failed");
                                    }
                                    break;
                                case 3:
                                    System.out.print("Amount: ");
                                    amount = scanner.nextInt();
                                    if(!account.deposit(amount)) {
                                        System.out.println("Deposit failed");
                                    }
                                    break;
                            }
                        } while(option != 0);
                    }
                    else {
                        System.out.println("Login failed");
                    }
                    break;
                case 2:
                    register();
                    break;
            }

        } while(choice != 0);
    }

    public boolean login() {
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        account = new Account(username, password);
        boolean result = account.loadAccount();
        return result;
    }

    public void register() {
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        account = new Account(username, password);
        account.saveNewAccount();
    }

    public int loginMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. EXIT");
        System.out.print("Select: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public int userMenu() {
        System.out.println("1. Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("0. EXIT");
        System.out.print("Select: ");
        int choice = scanner.nextInt();
        return choice;
    }
}
