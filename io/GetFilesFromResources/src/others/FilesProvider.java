package others;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BikchentaevAA
 */
public class FilesProvider {
    public String inRoot = "inRoot.json";
    public String inPkg = "inPkg.json";
    public String inSubPkg = "inSubPkg.json";
    
    public String extResInPkg = FilesProvider.class.getResource(inPkg).toExternalForm();
    public String extResInSubPkg = FilesProvider.class.getResource("res/"+inSubPkg).toExternalForm();

    public URI getUriInPkg(){
        try {
            return  new URI(extResInPkg);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FilesProvider.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public URI getUriInSubPkg(){
        try {
            return  new URI(extResInSubPkg);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FilesProvider.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
