package apachedoc.log4j;

/**
 *
 * @author ayrat
 * 
 * http://logging.apache.org/log4j/2.x/manual/configuration.html
 * 
 */
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
 
public class ApacheDoc {
 
    // Define a static logger variable so that it references the
    // Logger instance named "MyApp".
    private static final Logger logger = LogManager.getLogger(ApacheDoc.class);
 
    public static void main(final String... args) {
 
        // Set up a simple configuration that logs on the console.
 
        logger.warn("Entering application.");
        Bar bar = new Bar();
        if (!bar.doIt()) {
            logger.error("Didn't do it.");
        }
        logger.warn("Exiting application.");
    }
}
