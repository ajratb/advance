/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads.sg.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Ayrat
 */
public class Atomic {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(5); 
        if(ai.compareAndSet(5, 44)){
            System.out.println("Replaced 5 with new value:");
            System.out.println("ai = "+ ai);
        }
    }
   
}
