/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import static ru.waytosky.date.DateUtils.*;

/**
 *
 * @author Ayrat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        LocalDateAndTimeDemo ldt = new LocalDateAndTimeDemo();
//        ldt.showNow();
//        ldt.showOf(2017, Month.MARCH, 22, 17, 45, 0);
//       DateAndCalendarDemo dc = new DateAndCalendarDemo();
//       dc.showNow();
//       dc.showOf(2017,3, 22, 17, 45, 0);

        Date date;
        LocalDate locDate;
        LocalDateTime locDateTime;
        Calendar cal;
        XMLGregorianCalendar xCal;
        
        locDateTime=LocalDateTime.now();
        System.out.println("locDateTime: "+locDateTime);
        try {
            xCal=localDateTimeToXmlCalendar(locDateTime);
            System.out.println("xmlCalendar.getTime after converting:"+xCal);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        date=new Date();
        cal = new GregorianCalendar();
        cal.setTime(date);
        try {
            xCal=dateToXmlCalendar(date);
            System.out.println("xmlCalendar.getTime after converting:"+xCal);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
