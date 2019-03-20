
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author BikchentaevAA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static final String[] image_exts = {"JPG", "JPEG", "PNG"};
    public static void main(String[] args) {
//        try {
//            purgeDirectory("C:/temp");
//        } catch (IOException ioEx) {
//
//        }
        File testDir = new File("C:/temp");
        int maxLevel = getDirectoryMaxDepth(testDir, 0);
        System.out.printf("Max level for test folder is: %d", maxLevel);
    }

    public static void purgeDirectory(String dir) throws IOException {
// 1. Можно получить всех детей и для каждого из них делать проход
        Files.walk(Paths.get(dir))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(File::delete);
    }
    
    private static boolean isImage(Path filePath){
        
        return isImage(filePath.toFile());
    }
    
    private static boolean isImage(File file){
        String ext = getFileExt(file);
        ext = ext.toUpperCase();
        Stream<String> stream = Arrays.stream(image_exts);
        return stream.anyMatch(ext::equals);
    }
   
    public static String getFileExt(File file) {
      
        String ext = "";

        int i = file.getName().lastIndexOf('.');
        if (i > 0) {
            ext = file.getName().substring(i + 1);
        }
        return ext;
    }
    
    
    public static void deleteImgsFromDirectory(File dir){
        
    }

    public static int getDirectoryMaxDepth(File dir, int lvl) {
        File[] files = new File[0];
        if (dir.isDirectory()) {
            files = dir.listFiles();
            if (containsDirectory(files)) {
                lvl++;
            }
        }
        int max = lvl;
        for (File f : files) {
            int fLvl = getDirectoryMaxDepth(f, lvl);
            if (fLvl > max) {
                max = fLvl;
            }
        }
        return max;
    }

    private static boolean containsDirectory(File[] files) {
        for (File f : files) {
            if (f.isDirectory()) {
                return true;
            }
        }
        return false;
    }
}
