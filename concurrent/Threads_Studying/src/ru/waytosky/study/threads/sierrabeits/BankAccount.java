package ru.waytosky.study.threads.sierrabeits;

/**
 *
 * @author ayrat
 */
public class BankAccount {

    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount){
        balance=balance -amount;
    }
}
