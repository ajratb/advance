/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * http://howtodoinjava.com/core-java/io/java-loadreadwrite-properties-file-examples/
 */
public class PropertiesCache {

    private final Properties configProp = new Properties();

    private PropertiesCache() {
        //Private constructor to restrict new instances
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
        System.out.println("Read all properties from file");
        try {
            configProp.load(in);
        } catch (IOException e) {
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
        return configProp.getProperty(key);
    }

    public Set<String> getAllPropertyNames() {
        return configProp.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return configProp.containsKey(key);
    }

    public void setProperty(String key, String value) {
        configProp.setProperty(key, value);
    }

    public static void main(String[] args) {
        //Get individual properties
        System.out.println(PropertiesCache.getInstance().getProperty("firstName"));

        //All property names
        System.out.println(PropertiesCache.getInstance().getAllPropertyNames());

        PropertiesCache cache = PropertiesCache.getInstance();
        if (cache.containsKey("country") == false) {
            cache.setProperty("country", "INDIA");
        }
//Verify property
        System.out.println(cache.getProperty("country"));
    }

}