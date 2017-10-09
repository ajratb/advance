/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpoint.spring.log4j;

import org.apache.log4j.Logger;

/**
 *
 * @author ayrat
 */
public class HelloWorld {

    private String message;
    
    static Logger log = Logger.getLogger(HelloWorld.class.getName());

    public void setMessage(String msg) {
        this.message = msg;
        
    }

    public void getMessage() {
        System.out.println("You have a message:" + message);
        log.warn("info msg");
    }
    
     public void printThrowException() {
//             throws IllegalArgumentException{
	   System.out.println("Exception raised");
       throw new IllegalArgumentException();
   }
}
