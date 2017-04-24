/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads.sg;

/**
 *
 * @author ayrat
 */
public class RunnableWithTimeToQuit implements Runnable {

    //patentially shared variable. Static fields can also be concurrently 
    //accessed
    //see A Runnable with shared data
    //see alse One Runnable: Multiple Threads
    private int i;
    public volatile boolean timeToQuit = false;

    @Override
    public void run() {
        System.out.println("Thread started");
        while (!timeToQuit) {
            for (i = 0; i < 100; ++i) {
                System.out.println("i= " + i);
            }
        }
        System.out.println("Thread finishing");
    }

    public static void main(String[] args) {
        //One runnable for multiple threads is possible
        RunnableWithTimeToQuit re1 = new RunnableWithTimeToQuit();
        RunnableWithTimeToQuit re2 = new RunnableWithTimeToQuit();
        Thread t1 = new Thread(re1);
        t1.start();
        Thread t2 = new Thread(re2);
        t2.start();

        try {

            Thread.currentThread().sleep(10000L);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("in main thread");
        }

        re1.timeToQuit = true;
        re2.timeToQuit = true;
    }
    
    //    public static void main(String[] args) {
//        String field="";
//        String result="new value";
//        String last_value="last_value";
//        field=result=last_value;
//        System.out.println("field: " + field);
//        System.out.println("result: " + result);
//        System.out.println("last_value: " + last_value);
//    }
}
