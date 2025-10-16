package com.mahlafuna;

/**
 * The checking account that allows the users to borrow money from a pre-approved credit line if they are using
 * this kind of bank account
 */
public class CheckingAccount extends BankAccount {

    private final double overdraftLimit;
    private final int freeTransactions;
    private int transactionsCount;

    public CheckingAccount(String accountHolderName, String accountNumber, double initialAmount, double overdraftLimit) {
        super(accountNumber, accountHolderName, initialAmount);
        this.overdraftLimit = overdraftLimit;
        this.freeTransactions = 5;
        this.transactionsCount = 0;
    }

    /**
     * Withdraw money from savings account
     * @param amount the amount to be withdrawn from the account
     * R7 is the amount of money will be charged everytime the money is withdrawn from ATM or Store
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            balance -= amount;
            balance -= 7; //charging the users R7 if they withdraw money
            transactionsCount++;
        }
    }

    /**
     * R2 is the money that will be charged per month for the checking account users
     */
    @Override
    public void applyMonthlyFees() {
        if (transactionsCount > freeTransactions) {
            int excess = transactionsCount - freeTransactions;
            balance -= excess * 2.0;
        }
        transactionsCount = 0; //Reset for a new month
    }
}
