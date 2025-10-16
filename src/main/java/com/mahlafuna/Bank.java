package com.mahlafuna;

import java.util.*;

/**
 * The bank that holds all the bank accounts
 */
public class Bank {

    private final String bankName;
    private final List<BankAccount> bankAccounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.bankAccounts = new ArrayList<>();
    }

    /**
     * Add the created bank account to the bank
     * @param bankAccount the bank account that is being created by the user
     */
    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    /**
     * Get the existing bank accounts in the bank
     * @param accountNumber the account number for that account
     * @return the bank account if it was created or null if that account doesn't exist
     */
    public BankAccount getBankAccount(String accountNumber) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }
        return null;
    }

    /**
     * Get the monthly maintenance/chargers according to the bank account
     */
    public void applyMonthlyMaintenance() {
        for (BankAccount bankAccount : bankAccounts) {
            bankAccount.applyMonthlyFees();
        }
    }

    //Display everything in the screen
    public void displayAccounts() {
        System.out.println("\n=== Bank Name: " + bankName +" ====");
        for (BankAccount bankAccount : bankAccounts) {
            System.out.println("Holder Name: " + " - " + bankAccount.getAccountHolderName() + "\n" +
                "Account Number: " + " - " + bankAccount.getAccountNumber() + "\n" + "Balance: " + " - " +
                "R" + bankAccount.getBalance() + "\n"
            );
        }
    }
}
