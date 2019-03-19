package ru.waytosky;

import java.util.List;
import ru.waytosky.interfaces.WithFinal;
import ru.waytosky.interfaces.WithStatic;

/**
 * Enum can implement interface, but cannot extend class(abstract or not).
 * @author BikchentaevAA
 */
public enum NewEnum implements WithStatic<Integer>, WithFinal{
    
    ENUM;

    @Override
    public void showMessage() {
        WithStatic.showMsgFromStatic();
    }

    @Override
    public List<String> getStrings() {
        return WithFinal.strings;
    }
}
