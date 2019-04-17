package main;

/**
 *
 * @author BikchentaevAA
 */
public class Dog {
    private String nick;

    public Dog(String nick) {
        this.nick = nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
    
    @Override
    public String toString() {
        return "Dog{" + "nick=" + nick + '}';
    }
}
