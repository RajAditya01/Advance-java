// TestBankSystem.java
package com.bank.system;

import java.time.LocalDateTime;

public class TestBankSystem {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        AccountClosureService closureService = new AccountClosureService(loginService);
        TransactionService transactionService = new TransactionService(loginService);

        // Register a new user and create an account
        loginService.registerUser("john_doe", "password123");

        // Deposit and withdraw from the account
        BankAccount johnAccount = loginService.getAccount("john_doe");
        johnAccount.deposit(1000);
        johnAccount.withdraw(500);

        // Print transaction statement
        transactionService.printTransactionStatement("john_doe", LocalDateTime.now().minusDays(7), LocalDateTime.now());

        // Close the account
        closureService.closeAccount("john_doe");
    }
}
