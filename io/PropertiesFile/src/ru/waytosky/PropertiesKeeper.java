/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Ayrat
 */
public class PropertiesKeeper {
    
    private final Properties properties = new Properties();
    private final File file = new File("C:\\MyJava\\PROJECTS\\GIT\\advance\\io\\PropertiesFile\\config.properties");
    
    private PropertiesKeeper() {
        
        try(InputStream in = new FileInputStream(file)) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class LazyHolder {

        private static final PropertiesKeeper INSTANCE = new PropertiesKeeper();
    }

    public static PropertiesKeeper getInstance() {
        return LazyHolder.INSTANCE;
    }
    
    public String  getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public void setProperty(String key, String value){
        try(OutputStream out = new FileOutputStream(file)){
            properties.setProperty(key, value);
            properties.store(out, null);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        PropertiesKeeper propsKeeper = PropertiesKeeper.getInstance();
        System.out.println("dbuser is: "+ propsKeeper.getProperty("dbuser"));
        propsKeeper.setProperty("newOne", "exelent");
    }

}
