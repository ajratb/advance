package main;

/**
 *
 * @author BikchentaevAA
 */
public class ClassesAndObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dog alpha = new Dog("alpha");
        System.out.println("New dog: " + alpha.toString());
        staticSetNewDog(alpha);
        System.out.println("After that alpha is: " + alpha.toString());
        staticSetNewNick(alpha);
        System.out.println("After that alpha is: " + alpha.toString());
        ClassesAndObjects test = new ClassesAndObjects();
        test.setNewDog(alpha);
        System.out.println("After that alpha is: " + alpha.toString());
        test.setNewNick(alpha);
        System.out.println("After that alpha is: " + alpha.toString());
    }

    public static Dog staticSetNewDog(Dog dog) {
        System.out.println("");
        System.out.println("START staticSetNewDog with dog: " + dog.toString());
        dog = new Dog("StatyNew");
        System.out.println("- new dog from static is" + dog.toString());
        return dog;
    }

    public static Dog staticSetNewNick(Dog dog) {
        System.out.println("");
        System.out.println("START staticSetNewNick with dog: " + dog.toString());
        dog.setNick("StatyNick");
        System.out.println("- new dog nick is" + dog.toString());
        return dog;
    }

    public Dog setNewDog(Dog dog) {
        System.out.println("");
        System.out.println("START setNewDog with dog: " + dog.toString());
        dog = new Dog("NewAlpha");
        System.out.println("- new dog from static is" + dog.toString());
        return dog;
    }

    public Dog setNewNick(Dog dog) {
        System.out.println("");
        System.out.println("START setNewNick with dog: " + dog.toString());
        dog.setNick("NickAlpha");
        System.out.println("- new dog nick is" + dog.toString());
        return dog;
    }

}
