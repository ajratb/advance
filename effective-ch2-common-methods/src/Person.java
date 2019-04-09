
/**
 *
 * Guide to hashCode() in Java:
 * https://www.baeldung.com/java-hashcode
 *
 * @author BikchentaevAA
 */
public class Person implements Comparable<Person> {

    private final long id;
    private String name;
    private int age;

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person(id = " + id + ") " + " with name: " + name + " and age: " + age + ";";
    }

    //test logical equality
    @Override
    public boolean equals(Object obj) {
        
        if (obj == this)
            return true;
        
        if (obj == null) {
            return this == null;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        if (this == null) {
            return false;
        }

        return this.id == ((Person) obj).getId();
//        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {

        //return super.hashCode(); 
        //return Objects.hashCode(this); - the same
        //return Objects.hash(this);// the same as Arrays.hashCode(Object[] objs)
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + Integer.valueOf(age).hashCode();
        return result;
    }

    @Override
    public int compareTo(Person anotherPerson) {
        if (this.age > anotherPerson.age) {
            return 1;
        } else if (this.age < anotherPerson.age) {
            return -1;
        }
        return 0;
    }

}
