package ru.waytosky.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BikchentaevAA
 */
public interface WithFinal {
    final List<String> strings = new ArrayList<>(Arrays.asList(new String[]{"final123", "final4jj"}));// плохо получаю статичный доступ!
//    String s;
    List<String> getStrings();
}
