package ru.waytosky;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

/**
 *
 * @author BikchentaevAA
 */
public class PreferencesExample {

    public static void main(String[] args) throws IOException,
            BackingStoreException, InvalidPreferencesFormatException {
        if (!new File("config.xml").exists()) {
            Preferences preferences = Preferences.userRoot();
            preferences.putBoolean("openStartMenu", true);
            preferences.putBoolean("SavePass", true);
            preferences.put("UserName", "");
            preferences.put("PassWord", "123456");
            preferences.exportNode(new FileOutputStream("config.xml"));
        }

        Preferences.importPreferences(new FileInputStream("config.xml"));
        Preferences preferences = Preferences.userRoot();
        
        boolean bool = preferences.getBoolean("SavePass", false);
        System.out.println("Save pass is: " + bool);
        String str = preferences.get("PassWord", "");
        System.out.println("Password is " + str);
    }
}
