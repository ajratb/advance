package ru.waytosky;

/**
 * Enum can implement interface, but cannot extend class(abstract or not).
 * @author BikchentaevAA
 */
public enum NewEnum implements SimpleInterface{
    
    ENUM;

    @Override
    public void showMessage() {
        SimpleInterface.showMsgFromStatic();
    }
}
