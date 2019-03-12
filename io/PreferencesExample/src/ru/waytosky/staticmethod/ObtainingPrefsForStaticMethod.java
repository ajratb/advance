package ru.waytosky.staticmethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;


/**
 *
 * @author BikchentaevAA
 */
public class ObtainingPrefsForStaticMethod {
    static String ourNodeName = "/ru/waytosky/staticmethod";

    private static final String FILE_NAME = "config_from_static.xml";
    
    static void createPrefs() throws BackingStoreException, IOException{
         
        Preferences preferences = Preferences.userRoot().node(ourNodeName);
        preferences.putBoolean("openStartMenu", true);
        preferences.putBoolean("SavePass", true);
        preferences.put("UserName", "");
        preferences.put("PassWord", "123456");
        preferences.exportNode(new FileOutputStream(FILE_NAME));
    }
    
    public static void main(String[] args) throws BackingStoreException, IOException{
        createPrefs();
    }
}
