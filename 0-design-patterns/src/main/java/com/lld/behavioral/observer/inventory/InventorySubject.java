package com.lld.behavioral.observer.inventory;

import java.util.*;

public class InventorySubject implements Subject{

    private Map<String, Set<Observer>> observers;

    public InventorySubject() {
        this.observers = new HashMap<>();
    }


    @Override
    public void subscribe(String item, Observer observer) {
        observers.putIfAbsent(item, new HashSet<>());
        observers.get(item).add(observer);
    }

    @Override
    public void unsubscribe(String item, Observer observer) {
        if (observers.containsKey(item)) {
            observers.get(item).remove(observer);
            if (observers.get(item).isEmpty()) {
                observers.remove(item);
            }
        }
    }

    @Override
    public void notifyObservers(String item, String message) {
        for (Observer observer : observers.get(item)) {
            observer.update(message);
        }
    }
}
