/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads.effective;

/**
 *
 * @author Ayrat
 */
public interface SetObserver<E> {
    //Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
