package com.lld.behavioral.observer.inventory;

/**
 * Subject (Observable) contract for the sample Observer implementation.
 *
 * Design note (learning/interview): this sample uses a simple, canonical
 * broadcast model: the subject holds a single registry of observers per item
 * and calls {@code update(event)} on each subscriber for that item. Observers
 * filter the event and act only on relevant EventType (IN_STOCK / OUT_OF_STOCK).
 *
 * This keeps the API small and easy to explain. For large-scale systems you
 * might prefer subject-side routing (subscribe with event interests, or a
 * composite key of item+event-type) to avoid calling irrelevant observers.
 */
public interface Subject {
    void subscribe(String item, Observer observer);
    void unsubscribe(String item, Observer observer);
    void notifyObservers(InventoryEvent event);
}
