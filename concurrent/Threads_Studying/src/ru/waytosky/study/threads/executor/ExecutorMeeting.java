package ru.waytosky.study.threads.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ayrat
 */
public class ExecutorMeeting {

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("i am myTask");
        }

    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executor.execute(new MyRunnable());
            System.out.println(i + "\n");
        }
        Future<String> f = executor.submit(() -> "result");
        int j = 0;
        while (!f.isDone()) {
            System.out.println(++j);
        }
        try {
            System.out.println(f.get());
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        executor.shutdown();//the executor to terminate gracefully 
        //(if you fail to do this, it is likely that your VM will not exit)
        // see void shutdownAndAwaitTermination(ExecutorService pool) 
    }

    /**
     * From ExecutorService JavaDoc.
     * The following method shuts down an ExecutorService in two phases, 
     * first by calling shutdown to reject incoming tasks, and then 
     * calling shutdownNow, if necessary, to cancel any lingering tasks: 
     * 
     * @param pool 
     */
    void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
