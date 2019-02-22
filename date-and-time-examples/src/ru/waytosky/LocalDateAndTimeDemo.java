/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Ayrat
 */
public class LocalDateAndTimeDemo {

    LocalDate locDate;
    LocalTime locTime;
    LocalDateTime locDateTime;

    String dateFormat = "yyyy-MM-dd";
    String timeFormat = "HH:mm:ss.SSS";
    String dateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS";//"d MMMM, EEEE"

    DateTimeFormatter df
            = DateTimeFormatter.ofPattern(dateFormat);
    DateTimeFormatter tf
            = DateTimeFormatter.ofPattern(timeFormat);
    DateTimeFormatter dtf
            = DateTimeFormatter.ofPattern(dateTimeFormat);

    public void showNow() {

        locDate = LocalDate.now();
        locTime = LocalTime.now();
        locDateTime = LocalDateTime.now();

        System.out.println("Without formating locDate is: " + locDate);
        System.out.println("Without formating locTime is: " + locTime);
        System.out.println("Without formating locDateTime is: " + locDateTime);

        System.out.println("With formating locDate is: "
                + locDate.format(df));
        System.out.println("With formating locTime is: "
                + locTime.format(tf));
        System.out.println("With formating locDateTime is: "
                + locDateTime.format(dtf));
    }

    public void showOf(int year, Month month, int dayOfMonth, int hour,
            int minute, int sec) {

        locDate = LocalDate.of(year, month, dayOfMonth);
        locTime = LocalTime.of(hour, minute, sec);
        locDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute, sec);

        System.out.println("Without formating locDate is: " + locDate);
        System.out.println("Without formating locTime is: " + locTime);
        System.out.println("Without formating locDateTime is: " + locDateTime);

        System.out.println("With formating locDate is: "
                + locDate.format(df));
        System.out.println("With formating locTime is: "
                + locTime.format(tf));
        System.out.println("With formating locDateTime is: "
                + locDateTime.format(dtf));
    }
}
