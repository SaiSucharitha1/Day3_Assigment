package app;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements BankOperations {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with balance: ₹" + initialBalance);
    }

    // Abstract methods to be implemented by subclasses
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    // Common method for transferring amount
    @Override
    public void transfer(Account target, double amount) {
        if (this.balance >= amount) {
            this.withdraw(amount);
            target.deposit(amount);
            addTransaction("Transferred ₹" + amount + " to Account " + target.accountNumber);
            target.addTransaction("Received ₹" + amount + " from Account " + this.accountNumber);
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }

    // Check current balance
    @Override
    public double checkBalance() {
        return balance;
    }

    // Log a transaction
    protected void addTransaction(String info) {
        transactionHistory.add(info);
    }

    // Show all transactions
    @Override
    public void showTransactionHistory() {
        System.out.println("Account: " + accountNumber);
        for (String entry : transactionHistory) {
            System.out.println(" - " + entry);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
