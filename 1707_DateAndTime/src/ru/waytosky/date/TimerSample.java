/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.date;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Ayrat
 */
public class TimerSample {
    
    private TimerTask tt = new TimerTask() {
            DateTimeFormatter timeFormatter
                    = DateTimeFormatter.ofPattern("HH:mm");

            @Override
            public void run() {
                System.out.println(LocalTime.now().format(timeFormatter));
            }
        };
    
    public void showTime(){
          
        Timer timer = new Timer();
        timer.schedule(tt, 0, 1000);
        
    }
}
