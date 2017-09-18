/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.date;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Ayrat
 */
public class DateAndCalendarDemo {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    Calendar cal;
    Date date;

    public void showNow() {
        Date date = new Date();
        System.out.println("Without formating date - now is: " + date);
        System.out.println("Formating date - now is: " + sdf.format(date));
        cal = new GregorianCalendar();
        Calendar cal2 = Calendar.getInstance();//тоже Gregorian
        cal.setTime(date);
        System.out.println("GregorianCalendar is: " + cal);
        System.out.println("GregorianCalendar getTime is: " + cal.getTime());
        System.out.println("Calendar.getInstance: "+cal2); 
    }

    public void showOf(int year, int month, int dayOfMonth, int hour,
            int minute, int sec) {
        cal = new GregorianCalendar(year, month - 1, dayOfMonth, hour, minute, sec);
        System.out.println("Calendar \"Of\" getTime: " + cal.getTime());
    }
}
