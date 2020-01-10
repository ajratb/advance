package main;

/**
 *
 * @author BikchentaevAA
 */
public abstract class SuperAnimal {
    
    private String type;
    protected String nick;

    public SuperAnimal(String type, String nick) {
        this.nick = nick;
        this.type = type;
    }
    
    public static void getSuperAnimalType(SuperAnimal beast){
        System.out.println("Super Animal type is: " + beast.type);
    }
}
