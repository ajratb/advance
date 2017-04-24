/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads.effective;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *Error - starts alien method from synchronized block
 * see 16 and 21
 * @author ayrat
 */
public class ObservableSet<E> extends ForwardingSet<E>{
    public ObservableSet(Set<E> set){super(set);} 
    private final List<SetObserver<E>> observers = new ArrayList<>();
   
}
