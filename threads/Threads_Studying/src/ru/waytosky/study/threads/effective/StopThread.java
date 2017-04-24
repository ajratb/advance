/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads.effective;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author ayrat
 */
public class StopThread {

    private static volatile boolean stopRequested;
    
//    private static synchronized void requestStop() {
//        stopRequested=true;
//    }
//
//    private static synchronized boolean stopRequested() {
//        return stopRequested;
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested) {
                    i++;
                }
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested=true;
    }
}
