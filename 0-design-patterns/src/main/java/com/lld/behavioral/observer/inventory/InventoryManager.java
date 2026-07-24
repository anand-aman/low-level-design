package com.lld.behavioral.observer.inventory;

/**
 * InventoryManager observer: subscribes to items and gets notified when an
 * item becomes OUT_OF_STOCK. The observer receives an {@link InventoryEvent}
 * and filters for OUT_OF_STOCK events.
 */
public class InventoryManager implements Observer {
    private String name;

    public InventoryManager(String name) {
        this.name = name;
    }

    @Override
    public void update(InventoryEvent event) {
        if (event.isOutOfStock()) {
            System.out.println("Alert InventoryManager " + name + "! " + event.getItem() + " is now out of stock!");
        }
    }
}

