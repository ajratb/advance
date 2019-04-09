
import java.util.Arrays;
import java.util.Objects;


/**
 *
 * @author BikchentaevAA
 */
public class ComparatorAndComparable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int objsHash = Objects.hash(Integer.valueOf(5), "abs");
        int arraysHash = Arrays.hashCode(new Object[]{Integer.valueOf(5), "abs"});
        System.out.println(objsHash);
        System.out.println(arraysHash);
    }
    
}
