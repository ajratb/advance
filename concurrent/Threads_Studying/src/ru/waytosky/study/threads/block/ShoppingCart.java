package ru.waytosky.study.threads.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author ayrat
 */
public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

//    public synchronized void addItem(Item item) {
//        items.add(item);
//    }
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void addItem(Item item) {
        rwl.writeLock().lock();
        try {
            // modify shopping cart
            items.add(item);
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public synchronized void removeItem(int index) {
        items.remove(index);
    }

    public synchronized void printCart() {
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            Iterator<Item> ii = items.iterator();
            while (ii.hasNext()) {
                Item i = ii.next();
                sb.append("Item: ");
                sb.append(i.getDescription());
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static ShoppingCart cart = new ShoppingCart();

    private static Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem(new Item("first"));
            cart.printCart();
        }
    });

    public static void main(String[] args) throws InterruptedException {
        t.start();
    }

    public static class Item {

        private String description;

        public String getDescription() {
            return description;
        }

        public Item(String description) {
            this.description = description;
        }

    }
}
