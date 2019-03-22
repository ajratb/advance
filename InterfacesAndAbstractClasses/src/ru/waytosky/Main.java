package ru.waytosky;

import java.util.List;

/**
 *
 * @author BikchentaevAA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> strings = SimpleInterface.STRINGS;        
        strings.forEach(System.out::println);
        SimpleInterface.showMsgFromStatic();
        NewEnum.ENUM.showMessage();
    }
    
}
