
import ru.wts.Singleton;


/**
 *
 * @author BikchentaevAA
 */
public class Main {
    public static void main(String[] args) {
        Singleton sngl = Singleton.INSTANCE;
        System.out.println(sngl.getVal());
        sngl.setVal("new value");
        System.out.println(sngl.getVal());
    }
    
}
