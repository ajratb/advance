/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads.sierrabeits;

/**
 *
 * @author Ayrat
 */
public class TestSync implements Runnable{
    private int balance;
    
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            increment();
            System.out.println("Balance is "+balance);
        }
    }
    
    public synchronized void increment(){
        int i=balance;
        balance=i+1;
    }
    
    public static void main(String[] args) {
        TestSync job = new TestSync();
        Thread a=new Thread(job);
        Thread b =new Thread(job);
        a.start();
        b.start();
    }
   
}
