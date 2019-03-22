package ru.waytosky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BikchentaevAA
 */
public interface SimpleInterface {
    
    //always public static final
    List<String> STRINGS = new ArrayList<>(Arrays.asList(new String[]{"staticl123", "static4jj"}));
    
    static void showMsgFromStatic(){
        System.out.println("hello from static");
    }
    
    void showMessage();
}
