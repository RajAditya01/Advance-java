// Transaction.java
package com.bank.system;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.date = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
