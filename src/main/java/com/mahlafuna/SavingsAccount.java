package com.mahlafuna;

public class SavingsAccount extends BankAccount {

    private final double interestRate;
    private final double minimumAmount;

    public SavingsAccount(String accountHolderName, String accountNumber, double initialAmount, double interestRate) {
        super(accountNumber, accountHolderName, initialAmount);
        this.interestRate = interestRate;
        this.minimumAmount = 100.0;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= minimumAmount) {
            balance -= amount;
            balance -= 7; //charging the user R7 if she/he withdraws money
        } else  {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    @Override
    public void applyMonthlyFees() {
        balance += balance * (interestRate / 12);
    }
}
