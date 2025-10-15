package com.mahlafuna;

import java.util.*;

public class Bank {

    private final String bankName;
    private final List<BankAccount> bankAccounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.bankAccounts = new ArrayList<>();
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public BankAccount getAllAccounts(String accountNumber) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }
        return null;
    }

    public void applyMonthlyMaintenance() {
        for (BankAccount bankAccount : bankAccounts) {
            bankAccount.applyMonthlyFees();
        }
    }

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
