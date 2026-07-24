package com.lld.behavioral.observer.inventory;

public class Demo {
    public static void main(String[] args) {
        Subject inventorySubject = new InventorySubject();
        Inventory inventory = new Inventory(inventorySubject);

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        Customer customer3 = new Customer("Carl");

        inventorySubject.subscribe("Item-5", customer1);
        inventorySubject.subscribe("Item-5", customer3);
        inventorySubject.subscribe("Item-4", customer2);

        inventory.updateStock("Item-5", 5);

    }
}
