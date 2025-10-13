package com.mahlafuna;

public abstract class BankAccount {

    private final String accountNumber;
    private final String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);
    public abstract void applyMonthlyFees();

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void transferFunds(BankAccount targetedAccount, double amount) {
        if (amount > 0 && balance >= amount) {
            this.withdraw(amount);
            targetedAccount.deposit(amount);
        }
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }
}
