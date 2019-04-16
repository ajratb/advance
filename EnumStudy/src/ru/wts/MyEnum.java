package ru.wts;

/**
 *
 * @author BikchentaevAA
 */
public enum MyEnum {
    FRIEND("grass"), ENEMY("tabaco");
    private String name;

    private MyEnum(String name) {
        this.name = name;
    }
    public static void printName(MyEnum myEnum){
        System.out.println(myEnum.name);
    }
}
