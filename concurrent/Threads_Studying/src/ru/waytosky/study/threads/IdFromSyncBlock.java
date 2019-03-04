package ru.waytosky.study.threads;

/**
 *
 * @author Ayrat
 */
public class IdFromSyncBlock {
    private static int  idSequence;
    
    private static synchronized int nextId(){
        return ++idSequence;
    }
    
    private final int id;

    public IdFromSyncBlock() {
        this.id = nextId();
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
