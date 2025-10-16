package com.mahlafuna;

/**
 * This is the Savings account that helps the users to saving their money and get the interest per month
 * while using this account
 */
public class SavingsAccount extends BankAccount {

    private final double interestRate;
    private final double minimumAmount;

    public SavingsAccount(String accountHolderName, String accountNumber, double initialAmount, double interestRate) {
        super(accountNumber, accountHolderName, initialAmount);
        this.interestRate = interestRate;
        this.minimumAmount = 100.0;
    }

    /**
     * Withdraw money from savings account
     * @param amount the amount to be withdrawn from the account
     * R7 is the amount of money will be charged everytime the money is withdrawn from ATM or Store
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= minimumAmount) {
            balance -= amount;
            balance -= 7;
        } else  {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    /**
     * Add interest instead of charging fees per month
     */
    @Override
    public void applyMonthlyFees() { balance += balance * (interestRate / 12); }
}
