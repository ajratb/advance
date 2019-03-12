package ru.waytosky.backingstore;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 *
 * @author BikchentaevAA
 */
public class DeterminingBackingStoreStatus {
    private static final String BACKING_STORE_AVAIL = "BackingStoreAvail";

    private static boolean backingStoreAvailable() {
        Preferences prefs = Preferences.userRoot().node("<temporary>");
        try {
            boolean oldValue = prefs.getBoolean(BACKING_STORE_AVAIL, false);
            prefs.putBoolean(BACKING_STORE_AVAIL, !oldValue);
            prefs.flush();
        } catch(BackingStoreException e) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("is backing store available: " + backingStoreAvailable());
    }
}
