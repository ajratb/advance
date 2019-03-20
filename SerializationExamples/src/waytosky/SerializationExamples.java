package waytosky;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author BikchentaevAA
 */
public class SerializationExamples {

//    private static final String file = System.getProperty("user.home") 
//            + "\\AppData\\Roaming\\ИСС Канцелярия\\data\\emp_aliases.ser";
//    

    private static final String file = "aliases.ser";

    public static void main(String[] args) {
        Map<Long, String[]> hashmap = new HashMap<>();
        hashmap.put(231L, new String[]{"ГГД", "РЛ"});
        hashmap.put(453L, new String[]{"ГД", "РssЛ"});
        serializeMap(hashmap);
        Map<Long, String[]> newmap = deserializeMap();
        newmap.forEach((k,v)->{
            System.out.println("entry key is "+k+" firstVal is "+v[0]+
                    " secondVal is "+ v[1]);
        });
    }

    public static void serializeMap(Map<Long, String[]> map) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String, String> anotherList = (Map<String, String>) ois.readObject();
            ois.close();
            System.out.println(anotherList);

        } catch (FileNotFoundException fileEx) {
            System.out.println("FileNotFoundException");
        } catch (IOException ioEx) {
            System.out.println("IOException");
        } catch (ClassNotFoundException classEx) {
            System.out.println("ClassNotFoundException");
        }
    }

    public static Map<Long, String[]> deserializeMap() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Map<Long, String[]> resultMap = (Map<Long, String[]>) ois.readObject();
            return resultMap;
        } catch (FileNotFoundException fileEx) {
            System.out.println("FileNotFoundException");
        } catch (IOException ioEx) {
            System.out.println("IOException");
        } catch (ClassNotFoundException classEx) {
            System.out.println("ClassNotFoundException");
        }
        return null;
    }

}
