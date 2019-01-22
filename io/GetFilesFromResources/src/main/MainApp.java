package main;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import others.FilesProvider;

/**
 * Примеры для проектов ANT
 * @author BikchentaevAA
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FilesProvider prv = new FilesProvider();
        
        File fileInRoot = new File(prv.inRoot);//must exist
        System.out.println("fileInRoot must exist: " + fileInRoot.exists());
        File fileInPkgFromRoot = new File("src/others/"+prv.inPkg);
        System.out.println("fileInPkgFromRoot must exist: " + fileInPkgFromRoot.exists());
        
        Path pathInPkg = Paths.get(prv.getUriInPkg());
        System.out.println("pathInPkg -> file must exist: " + pathInPkg.toFile().exists());
        Path pathInSubPkg = Paths.get(prv.getUriInSubPkg());
        System.out.println("pathInSubPkg -> file must exist: " + pathInSubPkg.toFile().exists());
    }
    
}
