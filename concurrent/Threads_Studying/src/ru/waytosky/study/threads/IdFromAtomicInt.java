package ru.waytosky.study.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Ayrat
 */
public class IdFromAtomicInt {
    private static final AtomicInteger idSequence = new AtomicInteger();
    
    private static int nextId(){
        return idSequence.incrementAndGet();
    }
    
    private final  int id;

    public IdFromAtomicInt() {
        this.id = nextId();
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

}
