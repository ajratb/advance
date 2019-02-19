package ru.waytosky;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author BikchentaevAA
 */
public class DefaultPackageProperties {

    public static void main(String[] args) throws URISyntaxException {
        File file = new File("config.properties");
        if (file.exists()) {
            System.out.println("OK");
        }
        //DefaultPackageProperties.class.getResource("config.properties").toURI() - NULL !
        URI uri = DefaultPackageProperties.class.getClassLoader().getResource("config.properties").toURI();
        Path path = Paths.get(uri);
        if (Files.exists(path)) {
            System.out.println("OK - file from resource exists");
        }
        System.out.println(uri); 
//        try{
//            
//        }catch(FileSystemException fsEx){
//            
//        }
    }
}
