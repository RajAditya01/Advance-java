// LoginService.java
package com.bank.system;

import java.util.HashMap;

public class LoginService {
    private HashMap<String, User> usersDatabase;
    private HashMap<String, BankAccount> accountsDatabase;

    public LoginService() {
        this.usersDatabase = new HashMap<>();
        this.accountsDatabase = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        User newUser = new User(username, password);
        usersDatabase.put(username, newUser);

        // Create a new bank account for the user
        BankAccount newAccount = new BankAccount("ACC" + username.hashCode());
        accountsDatabase.put(username, newAccount);
    }

    public boolean authenticateUser(String username, String password) {
        User user = usersDatabase.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public BankAccount getAccount(String username) {
        return accountsDatabase.get(username);
    }
}
