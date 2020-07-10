package site.codeflow;

import java.io.Serializable;

/**
 *
 * @author BikchentaevAA
 */
public class Person implements Serializable{
    
//    private static final long serialVersionUID = 1L;
// версия класса для контроля изменений
// если не объявлен jvm присваивает его автоматически
// для генерации можно использовать IDE
    // InvalidClassExceptions - при несоот-ии версий

    private int age;
    private String name;
    static String country;//must be serializable too
    transient int height;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
