/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayrat
 */
public class IdSequenceDemo {
    public static void main(String[] args) throws Exception{
        List<Thread> threads= new ArrayList<>();
        
        System.out.println("-- Ids generated with AtomicInteger");
        for(int i=0; i<10; ++i){
            ThreadWithAtomicInt thread = new ThreadWithAtomicInt();
            threads.add(thread);
            thread.start();
        }
        
        joinAllThreads(threads);
        System.out.println();
        
    }

    private static void joinAllThreads(List<Thread> threads) throws Exception{
        for(Thread thread: threads){
           thread.join();
        } 
        threads.clear();
    }
}
