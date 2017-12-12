/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Ayrat
 */
public class IdFromAtomicInt {
    private static final AtomicInteger idSequence = new AtomicInteger();
    
    private static int nextId(){
        return idSequence.incrementAndGet();
    }
    
    private final  int id;

    public IdFromAtomicInt() {
        this.id = nextId();
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
    
    
    
   
}
