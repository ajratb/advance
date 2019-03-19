package ru.waytosky;

import ru.waytosky.interfaces.WithFinal;
import java.util.List;

/**
 *
 * @author BikchentaevAA
 */
public class WithFinalImpl implements WithFinal{

    @Override
    public List<String> getStrings() {
        return strings;
    }
    
}
