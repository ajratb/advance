
import java.util.Random;

/*
 * https://ru.stackoverflow.com/questions/2473/%D0%A1%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D1%8B%D0%B5-%D1%87%D0%B8%D1%81%D0%BB%D0%B0
 * https://stackoverflow.com/questions/11239495/checking-if-file-is-completely-written
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
//        int a = 10000; // Начальное значение диапазона - "от"
//        int b = 100000; // Конечное значение диапазона - "до"
//        int random_number1 = a + (int) (Math.random() * b); // Генерация 1-го числа
//        System.out.println("1-ое случайное число: " + random_number1);

        int min = 10000;
        int max = 100000;
        Random rnd = new Random(System.currentTimeMillis());
        int number;
// Получаем случайное число в диапазоне от min до max (включительно)
        for (int i = 0; i < 5; i++) {
            number = min + rnd.nextInt(max - min + 1);
            System.out.println(number);
        }
    }

}
