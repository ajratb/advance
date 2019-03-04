package ru.waytosky.study.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Ayrat
 */
public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(5); 
        if(ai.compareAndSet(5, 44)){
            System.out.println("Replaced 5 with new value:");
            System.out.println("ai = "+ ai);
        }
    }
   
}
