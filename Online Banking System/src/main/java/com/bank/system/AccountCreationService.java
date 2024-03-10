// AccountCreationService.java
package com.bank.system;

public class AccountCreationService {
    private LoginService loginService;

    public AccountCreationService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void createAccount(String username, String password) {
        if (!loginService.authenticateUser(username, password)) {
            // User authentication failed
            System.out.println("Invalid credentials for user: " + username);
            return;
        }

        if (loginService.getAccount(username) != null) {
            // User already has an account
            System.out.println("User " + username + " already has an account");
            return;
        }

        // Create a new bank account for the user
        BankAccount newAccount = new BankAccount("ACC" + username.hashCode());
        loginService.accountsDatabase.put(username, newAccount);
        System.out.println("Account created successfully for user: " + username);
    }
}
