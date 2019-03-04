package ru.waytosky.study.threads.executor;

import javafx.concurrent.Task;

/**
 * It is strange for me why I can not use its instance as a callable in executor.submit method.
 * 
 * @author BikchentaevAA
 */
public class JfxTaskExample extends Task<Integer> {

    @Override
    public Integer call() throws Exception {
        int iterations;
        for (iterations = 0; iterations < 100000; iterations++) {
            if (isCancelled()) {
                break;
            }
            System.out.println("Iteration " + iterations);
        }
        return iterations;
    }

    @Override
    public void run() {
        System.out.println("in run method");
    }
    
}
