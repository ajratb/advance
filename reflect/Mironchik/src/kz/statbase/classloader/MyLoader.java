/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.statbase.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayrat
 */
public class MyLoader extends ClassLoader {

    public MyLoader() {
        super();
    }

//    @Override
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        return super.findClass(name); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("c:\\MyJava\\PROJECTS\\GIT\\reflect\\Mironchik\\res\\A1.class");
        byte b[] = new byte[(int) f.length()];

        try (FileInputStream fis = new FileInputStream(f)) {

            fis.read(b);
//            while(fis.read()>0){
//                
//            }
//            defineClass("kz.A1", b, protectionDomain)

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineClass("kz.A1", b, 0, b.length);
    }

}
