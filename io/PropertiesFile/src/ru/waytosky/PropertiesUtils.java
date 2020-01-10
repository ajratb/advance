package ru.waytosky;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author ayrat
 */
public class PropertiesUtils {

//    private static final String propsLocation = System.getProperty("user.home") + "\\AppData\\Roaming\\ИСС Канцелярия\\app.properties";
    private static final String propsLocation = "example.properties";
    private static Properties props;
//    private InputStream in;
//    private OutputStream out;

    public static String getPropertyByName(String name) throws IOException, FileNotFoundException {
        props = new Properties();
        File file = new File(propsLocation);
        if (!file.exists()) {
            throw new FileNotFoundException("Properties file not found");
        }
        try (InputStream in = new FileInputStream(file)) {
            props.load(in);
            return props.getProperty(name);
        }
    }

    public static void persistProperty(String name, String value) throws FileNotFoundException, IOException{
        props = new Properties();
        File file = new File(propsLocation);
        if (!file.exists()) {
            throw new FileNotFoundException("Properties file not found");
        }
        try (InputStream in = new FileInputStream(file)) {
            props.load(in);
           
        }
        try (FileOutputStream output = new FileOutputStream(file)) {
           
            props.setProperty(name, value);
            props.store(output, null);
//            return true;
        }
    }

    public static void persistProperties(Map<String, String> propsMap) throws IOException, FileNotFoundException {
        props = new Properties();
        File file = new File(propsLocation);
        if (!file.exists()) {
            throw new FileNotFoundException("Properties file not found");
        }
        try (FileOutputStream output = new FileOutputStream(file)) {
            for(Map.Entry<String,String> entry: propsMap.entrySet()){
                props.setProperty(entry.getKey(), entry.getValue());
            }
            props.store(output, null);
        }
        
    }
    
    public static void main(String[] args) {
        try {
            persistProperty("123", "456");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }

}
