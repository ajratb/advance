package ru.waytosky.study.threads.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author BikchentaevAA
 */
public class FutureExample {
    
    private static int poolSize = 2;
    private static ExecutorService executor = Executors.newFixedThreadPool(poolSize);
    
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        FutureTask<String> future
                = new FutureTask<String>(new Callable<String>() {
                    public String call() {
                        return String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
                    }
                });
        //= new FutureTask<String>(() -> String.valueOf(ThreadLocalRandom.current().nextInt(0, 10)));
        executor.execute(future);
        System.out.println("Result is: "+future.get());
    }
}
