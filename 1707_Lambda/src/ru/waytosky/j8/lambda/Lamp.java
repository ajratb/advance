/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.j8.lambda;

/**
 *
 * @author Ayrat
 */
public class Lamp implements Electronic {

    @Override
    public void launch() {
        System.out.println("lamp is switch on");
    }
    
}
