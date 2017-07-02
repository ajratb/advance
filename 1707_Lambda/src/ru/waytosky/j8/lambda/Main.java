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
public class Main {

    static void doSome(){
        System.out.println("i do");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Switcher s = new Switcher();
        s.addDevice(new Lamp());
        s.addDevice(()->  {
                System.out.println("state is ok");
            }
        );
        s.addDevice(Main::doSome);
        s.switchOn();
    }

}
