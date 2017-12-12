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
class ThreadWithAtomicInt extends Thread{

    @Override
    public void run() {
        for(int i=0;i<10;++i){
            System.out.println(new IdFromAtomicInt());
        }
    }
    
}
