/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waytosky.files;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ayrat
 */
public class OldNioStart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("d:\\123.txt");
        System.out.println("Abs Path : "+file.getAbsolutePath());
        try {
            System.out.println("Canonical Path : "+file.getCanonicalPath());
        } catch (IOException ex) {
            System.out.println("catch IOException during canonical path getting");
            Logger.getLogger(OldNioStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Get Path : "+file.getPath());
        System.out.println("");
        System.out.println("file is exist?: "+ file.exists());
    }
    
}
