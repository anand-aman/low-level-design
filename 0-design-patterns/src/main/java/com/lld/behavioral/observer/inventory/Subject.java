package com.lld.behavioral.observer.inventory;

public interface Subject {
    void subscribe(String item, Observer observer);
    void unsubscribe(String item, Observer observer);
    void notifyObservers(String item, String message);
}
