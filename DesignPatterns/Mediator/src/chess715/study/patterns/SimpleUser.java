/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess715.study.patterns;

import java.util.Objects;

/**
 *
 * @author ayrat
 */
public class SimpleUser implements User{
    
    Chat chat;
    
    String name;
    
    public SimpleUser(String name, Chat chat){
        this.chat=chat;
        chat.addUser(this);
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void getMessage(String message, User user) {
        System.out.println(this+" от " + user + " сообщение: "+message);
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
    
    @Override
    public String toString(){
        return getName() + hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleUser other = (SimpleUser) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    
    
}
