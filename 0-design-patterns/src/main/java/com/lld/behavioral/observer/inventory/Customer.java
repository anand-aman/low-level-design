package com.lld.behavioral.observer.inventory;

/**
 * Customer observer: subscribes to items and gets notified when an item
 * becomes IN_STOCK. The observer receives an {@link InventoryEvent} and
 * filters for IN_STOCK events.
 */
public class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(InventoryEvent event) {
        if (event.isInStock()) {
            System.out.println("Hi " + name + "! " + event.getItem() + " is now back in stock!");
        }
    }
}
