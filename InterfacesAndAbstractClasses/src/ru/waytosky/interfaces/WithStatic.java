
package ru.waytosky.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BikchentaevAA
 */
public interface WithStatic<T> {
    
    static List<String> staticStrings = new ArrayList<>(Arrays.asList(new String[]{"staticl123", "static4jj"}));
    
    static void showMsgFromStatic(){
        System.out.println("hello from static");
    }
    
    void showMessage();
}
