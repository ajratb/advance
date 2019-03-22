package ru.waytosky.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BikchentaevAA
 */
public interface WithFinal {
    //always public static final
    List<String> STRINGS = new ArrayList<>(Arrays.asList(new String[]{"final123", "final4jj"}));
    List<String> getStrings();
}
