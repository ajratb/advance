/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads;

/**
 *
 * @author Ayrat
 */
public class IdFromSyncBlock {
    private static int  idSequence;
    
    private static synchronized int nextId(){
        return ++idSequence;
    }
    
    private final int id;

    public IdFromSyncBlock() {
        this.id = nextId();
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
