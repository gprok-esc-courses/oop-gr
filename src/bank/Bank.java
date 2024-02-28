package bank;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private ArrayList<Account> accounts;
    private int nextId;

    public Bank() {
        accounts = new ArrayList<>();
        nextId = 1;
    }

    // Not real database, just fake data
    public void loadFromDatabase() {
        Faker faker = new Faker();
        Random rnd = new Random();
        for(int i = 0; i < 50; i++) {
            String name = faker.name().fullName();
            String address = faker.address().fullAddress();
            String phone = faker.phoneNumber().cellPhone();
            Account newAccount = addAccount(name, address, phone);
            newAccount.setCreditCard(faker.business().creditCardNumber());
            newAccount.setBalance(rnd.nextInt(100000));
        }
    }

    public Account addAccount(String name, String address, String phone) {
        Account account = new Account(nextId, name, address, phone);
        accounts.add(account);
        nextId++;
        return account;
    }

    public Account findAccount(int id) {
        for(Account account : accounts) {
            if(account.getId() == id) {
                return account;
            }
        }
        return null;
    }
}
