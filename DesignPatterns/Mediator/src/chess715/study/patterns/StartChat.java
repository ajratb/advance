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
public class StartChat {
    public static void main(String[] args) {
        Chat chat=new TextChat();
        
        User user1=new SimpleUser("Володя",chat);
        User user2=new SimpleUser("Валера",chat);
        User user3=new SimpleUser("Серёга",chat);
        
        user1.sendMessage("Здарова пассаны!");
        user2.sendMessage("Здаров! как сам?");
        
    }
}
