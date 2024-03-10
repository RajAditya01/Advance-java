// AccountClosureService.java
package com.bank.system;

public class AccountClosureService {
    private LoginService loginService;

    public AccountClosureService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void closeAccount(String username) {
        BankAccount account = loginService.getAccount(username);
        if (account != null) {
            // Additional logic for closing account (e.g., check for zero balance)
            loginService.accountsDatabase.remove(username);
            System.out.println("Account closed successfully for user: " + username);
        } else {
            System.out.println("Account not found for user: " + username);
        }
    }
}
