/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpoint.spring.aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * https://www.tutorialspoint.com/spring/schema_based_aop_appoach.htm
 * 
 * depends on: 
 * - aopalliance-1.0.jar
 * - aspectjweaver.jar
 * 
 * Configuration in: aop_beans.xml
 * @author Ayrat
 */
public class MainApp {
    public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("aop_beans.xml");

      Student student = (Student) context.getBean("student");

      student.getName();
//      student.getAge();
      
//      student.printThrowException();
   }
}
