package ru.waytosky;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.Set;

/**
 * http://howtodoinjava.com/core-java/io/java-loadreadwrite-properties-file-examples/
 */
public class PropertiesCache {

    private final Properties pkgProp = new Properties();

    private PropertiesCache() {
        //Private constructor to restrict new instances

        try {
            URI pkgPropsUri = getClass().getResource("app.properties").toURI();

            System.out.println("Read all properties from file");
            pkgProp.load(new FileInputStream(new File(pkgPropsUri)));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    //Bill Pugh Solution for singleton pattern
    private static class LazyHolder {

        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }

    public static PropertiesCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return pkgProp.getProperty(key);
    }

    public Set<String> getAllPropertyNames() {
        return pkgProp.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return pkgProp.containsKey(key);
    }

    public void setProperty(String key, String value) {
        pkgProp.setProperty(key, value);
    }

//    public static void main(String[] args) {
//
//        PropertiesCache keeper = getInstance();
//        //Get individual properties
//        System.out.println("User prop value: "+keeper.getProperty("user"));
//
//        //All property names
//        System.out.println("All props names: "+keeper.getAllPropertyNames());
//
//        PropertiesCache cache = PropertiesCache.getInstance();
//        if (cache.containsKey("country") == false) {
//            cache.setProperty("country", "INDIA");
//        }
//        //Verify property
//        System.out.println(cache.getProperty("country"));
//
//        System.out.println("boolVal" + keeper.getProperty("boolVal"));
//    }

}
 