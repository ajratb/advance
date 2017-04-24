/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky;

import java.io.IOException;
import java.io.InputStream;
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
        InputStream input = null;

        try {
            String filename = "config.properties";
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
