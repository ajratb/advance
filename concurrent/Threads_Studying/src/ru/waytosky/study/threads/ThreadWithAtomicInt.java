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
