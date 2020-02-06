/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess715.study.patterns;

/**
 *
 * @author ayrat
 */
public interface User {
    
    public void getMessage(String message, User user);
    public  void sendMessage(String message);
}
