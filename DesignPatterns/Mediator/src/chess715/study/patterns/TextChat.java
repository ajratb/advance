/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess715.study.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayrat
 */
public class TextChat implements Chat{
    List<User> users=new ArrayList();
    
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for(User u:users){
            if(u!=user){
                u.getMessage(message, user);
            }
        }
    }

    
}
