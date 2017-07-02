/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.j8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayrat
 */
public class Switcher {
    List<Electronic> devices =new ArrayList<>();
    
    void addDevice(Electronic device){
        devices.add(device);
    }
    
    void switchOn(){
        for(Electronic e:devices)
        e.launch();
    }
}
