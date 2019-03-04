package ru.waytosky.study.threads.sierrabeits;

/**
 *
 * @author ayrat
 */
public class RunThreads implements Runnable {

    public static void main(String[] args) {
        RunThreads runner = new RunThreads();
        Thread alpha = new Thread(runner);
        Thread beta = new Thread(runner);
        alpha.setName("поток альфа");
        beta.setName("поток бета");
        alpha.start();
        beta.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println("Сейчас работает " + threadName);

        }
    }
}
