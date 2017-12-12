
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayrat
 */
public class ProcessesAndRuntime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
//        ProcessBuilder pBuilder = new ProcessBuilder
            Runtime.getRuntime().exec("javaw -jar CSS.jar");
        } catch (IOException ex) {
            Logger.getLogger(ProcessesAndRuntime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
