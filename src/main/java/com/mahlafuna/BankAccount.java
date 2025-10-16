package com.mahlafuna;

/**
 * Creat a bank account of your choice and be able to do all the transactions you like
 */
public abstract class BankAccount {

    private final String accountNumber;
    private final String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    //Allow Savings & Checking accounts to implement these methods according to their types of accounts
    public abstract void withdraw(double amount);
    public abstract void applyMonthlyFees();

    /**
     * Deposit money to the bank account
     * @param amount the amount that is being deposited
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    /**
     * Transfer money from one account to another legit account
     * @param targetedAccount the account that money is being transfer to
     * @param amount the amount of money that is transfer from one account to another
     */
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
