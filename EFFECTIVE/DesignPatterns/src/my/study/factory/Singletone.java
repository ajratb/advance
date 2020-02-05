/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.study.factory;

/**
 *
 * @author Ayrat
 */
public class Singletone {
    private static Singletone instance;
    
    
    private Singletone(){
        
    }
    
    public static Singletone getInstance(){
        if(instance==null){
            instance=new Singletone();
        }
        return instance;
    }
    
    
}
