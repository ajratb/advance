
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ayrat
 */
public class RandomSample {

    /**
     * @param args the command line arguments
     */
    static final Random random = new Random(56);

    
    
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            int x = random.nextInt();
//            System.out.println("x: " + x);
//            System.out.println("Math.random(): "+Math.random());
//        }
        int a = 10000; // Начальное значение диапазона - "от"
        int b = 100000; // Конечное значение диапазона - "до"
        int random_number1 = a + (int) (Math.random() * b); // Генерация 1-го числа
        System.out.println("1-ое случайное число: " + random_number1);

    }

}
