package com.mahlafuna;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * These are unit tests that tests the functionality of the Bank App.
 */
public class BankAccountTest {
    @Test
    public void testSavingsBankAccount() {
        BankAccount account = new SavingsAccount("Jack", "123", 200.0, 1.0);
        assertNotNull(account);
        assertEquals("Jack", account.getAccountHolderName());
        assertEquals("123", account.getAccountNumber());
    }

    @Test
    public void testCheckingBankAccount() {
        BankAccount account = new CheckingAccount("Brazo", "1024", 100.0, 200.0);
        assertNotNull(account);
        assertEquals("Brazo", account.getAccountHolderName());
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testDeposit() {
        BankAccount account = new SavingsAccount("Jack", "123", 200.0, 1.0);
        account.deposit(50.0);
        assertEquals(250.0, account.getBalance());
    }

    @Test
    public void testWithdrawal() {
        BankAccount account = new CheckingAccount("Brazo", "5523", 50.0, 100.0);
        account.withdraw(15.0);
        assertEquals(28.0, account.getBalance()); //R7 is also included when withdrawal is made
    }

    @Test
    public void testTransfer() {
        BankAccount savingAccount = new SavingsAccount("Jack", "123", 200.0, 1.0);
        BankAccount checkingAccount = new CheckingAccount("Brazo", "4563", 50.0, 100.0);

        savingAccount.transferFunds(checkingAccount, 50.0);

        assertEquals(143.0, savingAccount.getBalance()); //R7 is also included
        assertEquals(100.0, checkingAccount.getBalance());
    }

    @Test
    public void testWithdrawingOverLimits() {
        BankAccount account = new SavingsAccount("Jack", "123", 200.0, 1.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(150.0), "Insufficient funds");
    }

    @Test
    public void testInterestRate() {
        Bank bank = new Bank("Test Bank");
        BankAccount savingsAccount = new SavingsAccount("Jack", "123", 200.0, 1.0);
        BankAccount checkingAccount = new CheckingAccount("Brazo", "5523", 50.0, 100.0);

        //add these accounts to the bank
        bank.addBankAccount(savingsAccount);
        bank.addBankAccount(checkingAccount);

        //withdraw some money
        savingsAccount.withdraw(20.0);

        //also transfer some money
        savingsAccount.transferFunds(checkingAccount, 20.0);

        //get monthly interest since it's saving account
        bank.applyMonthlyMaintenance();

        //their balances are not equal
        assertNotEquals(savingsAccount.getBalance(), checkingAccount.getBalance());
        //bank has some accounts in it
        assertNotNull(bank);
        //The interest rate is...?
        assertEquals(159.0, savingsAccount.getBalance());
    }
}
