/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * https://www.mkyong.com/java/java-properties-file-examples/
 */
public class PropertiesFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Properties prop = new Properties();
//        Properties prop1 = new Properties();
        InputStream input = null;
//        File file = new File(System.getProperty("user.home") + "\\AppData\\Roaming\\КанцелярияИСС");
//        if (!file.exists()) {
//            
//                file.mkdir();
//          
//        }
//        System.out.println(file.exists());
        Path path= Paths.get(System.getProperty("user.home") + "\\AppData\\Roaming\\Канцелярия ИСС\\app.properties");
        
        try {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileOutputStream output = new FileOutputStream(path.toFile())) {
            prop.setProperty("database", "localhost22");
            prop.setProperty("dbuser", "mkyong88");
            prop.setProperty("dbpassword", "password");
            prop.store(output, null);
        } catch (Exception e) {
            System.out.println("output exception");
        }
        try {
            String filename = "./config.properties";
            input = PropertiesFile.class.getClassLoader()
                    .getResourceAsStream(filename);

            if (input == null) {
                System.out.println("Sorry, unable to find" + filename);
                return;
            }

            prop.load(input);

            //get the property value and print it out
            System.out.println(prop.getProperty("database"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
