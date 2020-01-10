package main;

/**
 *
 * @author BikchentaevAA
 */
public class Dog extends SuperAnimal{

    public Dog( String nick) {
        super("DOG", nick);
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
    
    @Override
    public String toString() {
        return "Dog{" + "nick=" + nick + '}';
    }
}
