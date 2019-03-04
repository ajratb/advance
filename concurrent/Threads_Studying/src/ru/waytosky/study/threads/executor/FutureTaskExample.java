package ru.waytosky.study.threads.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *
 * @author BikchentaevAA
 */
public class FutureTaskExample extends FutureTask<Integer>{    
    public FutureTaskExample(Callable<Integer> callable) {
        super(callable);
    } 
}
