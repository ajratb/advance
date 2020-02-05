/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @author Ayrat
 */
public class InstrumentedSet<E> extends ForwardingSet<E>{
    private int addCount = 0;
    
    public InstrumentedSet(Set<E> s){
        super(s);
    }
    
    @Override 
    public boolean add(E e){
        addCount++;
        return super.add(e);
    }
    
    @Override
    public boolean addAll(Collection<? extends E> c){
        addCount+=c.size();
        return super.addAll(c);
    }
    
    public int getAddCount(){
        return addCount;
    }
}
