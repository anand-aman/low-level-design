package com.lld.behavioral.observer.inventory;

import java.util.*;

/**
 * Concrete Subject implementation using a single registry of observers per item.
 *
 * Behavior: when an InventoryEvent occurs, the subject looks up all observers
 * subscribed to that item and calls {@code update(event)} on each. Observers
 * are responsible for filtering events they care about (IN_STOCK vs OUT_OF_STOCK).
 *
 * This implementation favors simplicity and readability for learning and
 * interview purposes. If you need to avoid calling irrelevant observers, use
 * a registration model or composite-key (item+event-type) routing instead.
 */
public class InventorySubject implements Subject {

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
    public void notifyObservers(InventoryEvent event) {
        String item = event.getItem();
        if (observers.containsKey(item)) {
            for (Observer observer : observers.get(item)) {
                observer.update(event);
            }
        }
    }
}
