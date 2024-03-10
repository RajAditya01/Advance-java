// TransactionService.java
package com.bank.system;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionService {
    private LoginService loginService;

    public TransactionService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void printTransactionStatement(String username, LocalDateTime startDate, LocalDateTime endDate) {
        BankAccount account = loginService.getAccount(username);
        if (account != null) {
            List<Transaction> transactions = account.getTransactions();
            // Add logic to filter transactions based on the provided date range
            for (Transaction transaction : transactions) {
                System.out.println("Date: " + transaction.getDate() +
                        ", Type: " + transaction.getType() +
                        ", Amount: " + transaction.getAmount());
            }
        } else {
            System.out.println("Account not found for user: " + username);
        }
    }
}
