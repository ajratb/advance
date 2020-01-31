package ru.wts;

/**
 *
 * @author BikchentaevAA
 */
public class NewSingleton {
    
    private static  NewSingleton INSTANCE = null;
    
    static {
        INSTANCE = new NewSingleton();
    }
    
    private NewSingleton() {
    }
    
    public static NewSingleton getInstance() {
        return INSTANCE;
    }
    
//    private static class NewSingletonHolder {
//
//        
//    }
}
