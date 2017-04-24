/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads.sg.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Ayrat
 */
public class ShoppingCart {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    
    public  void addItem(Object o){
        rwl.writeLock().lock();
        // modify shopping cart
        rwl.writeLock().unlock();
    }
}
