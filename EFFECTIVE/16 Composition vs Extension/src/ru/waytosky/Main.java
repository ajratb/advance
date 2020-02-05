/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky;

import java.util.Arrays;

/**
 *
 * @author Ayrat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet();
        s.addAll(Arrays.asList("Snap","Crackle","Pop"));
        System.out.println(s.getAddCount());
       
    }
    
}
