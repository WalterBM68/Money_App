package com.mahlafuna;

public class CheckingAccount extends BankAccount {

    private final double overdraftLimit;
    private final int freeTransactions;
    private int transactionsCount;

    public CheckingAccount(String accountHolderName, String accountNumber, double initialAmount, double overdraftLimit) {
        super(accountHolderName, accountNumber, initialAmount);
        this.overdraftLimit = overdraftLimit;
        this.freeTransactions = 5;
        this.transactionsCount = 0;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            balance -= amount;
            transactionsCount++;
        }
    }

    @Override
    public void applyMonthlyFees() {
        if (transactionsCount >= freeTransactions) {
            int excess = transactionsCount - freeTransactions;
            balance = excess * 2.0;
        }
        transactionsCount = 0;
    }
}
