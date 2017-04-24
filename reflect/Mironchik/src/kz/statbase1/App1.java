/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.statbase1;

import java.lang.reflect.Method;

/**
 *
 * @author Ayrat
 */
public class App1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        A1 a = null;
        Class c;
        //c= a.class - doesn't work
        c = A1.class;
        a=new A1();
        c = a.getClass();
        try {
            c = Class.forName("kz.statbase1.A1");
            while(c.getSuperclass()!=null){
                System.out.println(c.getSuperclass());
                
                c=c.getSuperclass();
            }
            Method[] m=c.getMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println("   " + m[i].getName());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
