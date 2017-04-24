/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads.effective;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ayrat
 */
public class ExecutorMeeting {
    static class myTask implements Runnable{

        @Override
        public void run() {
            System.out.println("i am myTask");
        }
    
    }
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
             executor.execute(new myTask());
             System.out.println(i+"\n");
        }
       
        executor.shutdown();
    }
}
