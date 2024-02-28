package bank;

import java.util.Scanner;

public class BankMenu {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.loadFromDatabase();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Set Credit Card");
            System.out.println("4. Set Balance");
            System.out.println("5. Delete");
            System.out.println("6. Activate");
            System.out.println("0. EXIT");
            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = input.nextLine();
                    System.out.print("Address: ");
                    String address = input.nextLine();
                    System.out.print("Phone: ");
                    String phone = input.next();
                    bank.addAccount(name, address, phone);
                    break;
                case 2:
                    System.out.print("ID: ");
                    int id = input.nextInt();
                    Account account = bank.findAccount(id);
                    if(account == null) {
                        System.out.println("Account not found");
                    }
                    else {
                        System.out.println(account);
                    }
                    break;
                case 0:
                    break;
            }

        } while(choice != 0);
    }
}
