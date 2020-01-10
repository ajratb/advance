package ru.waytosky.advance.resources;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BikchentaevAA
 */
public class MainApp {

    public static void main(String[] args) {

        File file = new File("/img/123.png");// not exists
        if (file.exists()) {
            System.out.println("file from string exists");
        } else {
            System.out.println("file from string not exists");
        }

        URI uri = null;
        try {
            uri = MainApp.class.getResource("/img/123.png").toURI();
        } catch (URISyntaxException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        File fileFromUri = new File(uri);//exists
        if (fileFromUri.exists()) {
            System.out.println("file from uri exists");
        } else {
            System.out.println("file from uri not exists");
        }

    }
}
