package ru.waytosky.study.threads;

/**
 *
 * @author ayrat
 */
public class WorkerAndSleeper {

    static class SleeperThread extends Thread {

        @Override
        public void run() {
            try{
                sleep(100000000);
            }catch(InterruptedException ex){
                System.out.println("Sleeper is interrupted");
            }

        }
    }

    static class WorkerThread extends Thread {

        @Override
        public void run() {
            
            for (int i = 0; i < 10000000; i++) {
                if(i%100==0 && isInterrupted()){
                    System.out.println("Worker is interrupted");
                    break;
                }
            }

        }
    }
    
    
    
    public static void main(String[] args) throws InterruptedException{
        Thread worker = new WorkerThread();
        Thread sleeper = new SleeperThread();
        
        System.out.println("Starting threads");
        worker.start();
        sleeper.start();
        
        System.out.println("Interrupting threads");
        worker.interrupt();
        sleeper.interrupt();
        
        System.out.println("Joining threads");
        worker.join();
        sleeper.join();
    }
}
