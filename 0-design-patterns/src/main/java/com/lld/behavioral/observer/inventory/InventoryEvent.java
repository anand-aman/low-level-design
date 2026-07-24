package com.lld.behavioral.observer.inventory;

/**
 * Simple event object representing an item state transition. Note that this
 * event intentionally does not include numeric quantities: observers are
 * informed only that an item is either IN_STOCK or OUT_OF_STOCK.
 */
public class InventoryEvent {
    public enum EventType {
        IN_STOCK,
        OUT_OF_STOCK
    }

    private String item;
    private EventType eventType;

    public InventoryEvent(String item, EventType eventType) {
        this.item = item;
        this.eventType = eventType;
    }

    public String getItem() {
        return item;
    }

    public EventType getEventType() {
        return eventType;
    }

    public boolean isInStock() {
        return eventType == EventType.IN_STOCK;
    }

    public boolean isOutOfStock() {
        return eventType == EventType.OUT_OF_STOCK;
    }

    @Override
    public String toString() {
        return "InventoryEvent{" +
                "item='" + item + '\'' +
                ", eventType=" + eventType +
                '}';
    }
}

