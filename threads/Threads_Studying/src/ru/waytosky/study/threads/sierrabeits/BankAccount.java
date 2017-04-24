/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
