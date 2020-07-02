package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author BikchentaevAA
 */
public class FileManager {

    FileInputStream fis ;
    public FileManager() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("123.txt");
    }
    
    FileChannel getFileChannel(){
        return fis.getChannel();
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
            FileManager fm = new FileManager();
            FileChannel ch = fm.getFileChannel();
            ch.open(Paths.get("123.txt"), StandardOpenOption.APPEND);
        
    }

}
