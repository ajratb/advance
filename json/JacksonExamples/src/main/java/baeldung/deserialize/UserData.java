package baeldung.deserialize;

/**
 *
 * @author BikchentaevAA
 */
public class UserData {
    
    public int id;
    public String info;
    public User owner;

    public UserData() {
    }
    
    public UserData(int id, String itemName, User owner) {
        this.id = id;
        this.info = itemName;
        this.owner = owner;
    }
}
