package ru.waytosky;

import ru.waytosky.interfaces.WithStatic;
import ru.waytosky.interfaces.WithFinal;
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
        List<String> strings = WithFinal.strings;        
        strings.forEach(System.out::println);
        WithStatic.showMsgFromStatic();
        NewEnum.ENUM.showMessage();
        NewEnum.ENUM.getStrings().forEach(System.out::println);
    }
    
}
