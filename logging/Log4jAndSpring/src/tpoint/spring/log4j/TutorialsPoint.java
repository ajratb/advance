/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpoint.spring.log4j;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ayrat
 */
public class TutorialsPoint {

    /**
     * @param args the command line arguments
     */
    static Logger log = Logger.getLogger(TutorialsPoint.class.getName());

    public static void main(String[] args) {
        
        ApplicationContext context
                = new ClassPathXmlApplicationContext("beans.xml");

        log.info("Going to create HelloWord Obj");

        HelloWorld obj = (HelloWorld) context.getBean("hello");

        obj.getMessage();

        log.info("Exiting the program");

        try {
            obj.printThrowException();
        } catch (Exception ex) {
            log.error("ошибка, ебать: " + ex);
        }
        
        HelloWorld hw=new HelloWorld();
        hw.getMessage();
        hw.printThrowException();
    }
}
