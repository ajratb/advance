package ru.wts;

/**
 *
 * @author BikchentaevAA
 */
public enum Singleton {
    
    INSTANCE("BLSDFLSF", new Object());
    
    String val;
    Object obj;
    
    Singleton(String val, Object obj){
        this.val = val;
        this.obj = obj;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
    
    
    
}
