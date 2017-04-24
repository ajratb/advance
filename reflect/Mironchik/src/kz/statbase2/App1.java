/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.statbase2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayrat
 */
public class App1 {
   public App1(){
       System.out.println("---before javac----");
       try {
           Process p = Runtime.getRuntime().exec("javac "
                   + "c:\\MyJava\\PROJECTS\\GIT\\reflect\\Mironchik\\res\\A1.java");
           if(p.waitFor()!=0){
               System.out.println("Ошибка компиляции");
               InputStream in=p.getErrorStream();
               int c=0;
               byte[] b=new byte[512];
               while((c=in.read(b,0,b.length))>0){
                   System.out.write(b,0,c);
               }
               throw new Exception("Ошибка компиляции в JAVAC");
           }
           else{
               System.out.println("OK");
           }
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       System.out.println("---after javac----");
   }  
    public static void main(String[] args) {
        
        Runtime r;
        r = Runtime.getRuntime();
        System.out.println(r.freeMemory());
        
        App1 app1=new App1();
    }
}
