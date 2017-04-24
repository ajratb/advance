/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads.sg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ayrat
 */
public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item) {
        items.add(item);
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

        }
    });

    public static void main(String[] args) throws InterruptedException {

    }
}
