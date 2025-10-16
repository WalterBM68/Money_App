package com.mahlafuna;

public class BankApp {
    public static void main(String[] args) {
        //Create bank
        Bank bankName = new Bank("OOP Bank App");

        //Create bank accounts
        SavingsAccount account = new SavingsAccount("Jack", "1230", 200.0, 1.0);
        CheckingAccount checking = new CheckingAccount("Brazo", "1720", 50.0, 200.0);

        //Add the accounts to the bank
        bankName.addBankAccount(account);
        bankName.addBankAccount(checking);

        //Withdraw from savings account
        account.withdraw(20);

        //transfer money from savings account to checking account
        account.transferFunds(checking, 20);

        //Show the balance after the transactions
        bankName.displayAccounts();

        System.out.println("After Monthly Maintenance");

        bankName.applyMonthlyMaintenance();

        bankName.displayAccounts();
    }
}