/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Ayrat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("d MMMM, EEEE");
        System.out.println(date.plusDays(20).format(formatter));

        //LocalTime time = LocalTime.now();
        TimerTask tt = new TimerTask() {
            DateTimeFormatter timeFormatter
                    = DateTimeFormatter.ofPattern("HH:mm");

            @Override
            public void run() {
                System.out.println(LocalTime.now().format(timeFormatter));
            }
        };
        
        Timer timer = new Timer();
        timer.schedule(tt, 0, 1000);
    }
    
}
