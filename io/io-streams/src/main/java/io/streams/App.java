package io.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static Logger logger = Logger.getLogger(App.class.getName());

    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws URISyntaxException, 
            FileNotFoundException {
        
        System.out.println(new App().getGreeting());
        URI uri = App.class.getResource("/files/123").toURI();
        File file = new File(uri);
        if (file.exists()) {
            System.out.println("file exists");
        } else {
            System.out.println("doesn't exist");
        }
        try (FileInputStream fin = new FileInputStream(file)) {
            int total = fin.read();
            System.out.println("total: " + total);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
