package io.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author ayrat
 */
public class IO_Studying {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException{
        
        final URI uri = App.class.getResource("/files/123").toURI();
        final String LOCAL_FILE = "c:/temp/dest.txt";
        
        try (
                BufferedReader bufInput = new BufferedReader(new FileReader(new File(uri)));
                BufferedWriter bufOutput = new BufferedWriter(new FileWriter(LOCAL_FILE))) {

            String line = "";
            while ((line = bufInput.readLine()) != null) {
                bufOutput.write(line);
                bufOutput.newLine();
            }
        } catch (FileNotFoundException f) {
            System.out.println("File not found: " + f);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }

}
