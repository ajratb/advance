package ru.waytosky.study.threads.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import javafx.concurrent.Task;

/**
 *
 * @author BikchentaevAA
 */
public class TaskExecution{
    
    public static void main(String[] args) throws ExecutionException, 
            InterruptedException{
        
        ExecutorService executors = Executors.newFixedThreadPool(2);
//        Future f = executors.submit(new TaskExample());
//        System.out.println(f.get());
        executors.execute(new JfxTaskExample());
        executors.shutdown();
        
        List<Callable<Integer>> tasks = new ArrayList<>();
//        Callable callable = new TaskExample();
//        Callable<Integer> callable = new Task<Integer>() {
//            @Override
//            protected Integer call() throws Exception {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        }
//        tasks.add(new TaskExample());
        
        executors.invokeAll(tasks);
        
        new Thread(new JfxTaskExample()).start();
    }
}
