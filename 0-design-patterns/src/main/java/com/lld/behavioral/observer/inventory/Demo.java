package com.lld.behavioral.observer.inventory;

/**
 * Demo for the Observer pattern sample. This demo uses a simple broadcast
 * model where the subject notifies all subscribers for an item and observers
 * filter the event types they care about. This keeps the example small and
 * easy to explain; for scale you'd route only to interested observers.
 */
public class Demo {
    public static void main(String[] args) {
        Subject inventorySubject = new InventorySubject();
        Inventory inventory = new Inventory(inventorySubject);

        // Customers waiting for Item-A to be available
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        Customer customer3 = new Customer("Carl");

        // Managers monitoring stock
        InventoryManager manager1 = new InventoryManager("John");
        InventoryManager manager2 = new InventoryManager("Sarah");

        System.out.println("=== Subscribing Customers to Item-A (waiting for IN_STOCK) ===");
        inventorySubject.subscribe("Item-A", customer1);
        inventorySubject.subscribe("Item-A", customer3);

        System.out.println("\n=== Subscribing Managers to Item-B (monitoring OUT_OF_STOCK) ===");
        inventorySubject.subscribe("Item-B", manager1);
        inventorySubject.subscribe("Item-B", manager2);

        System.out.println("\n=== Selling Item-A (1 -> 0, goes OUT_OF_STOCK) ===");
        inventory.sellItem("Item-A");  // Managers don't care, only customers do

        System.out.println("\n=== Restocking Item-A (0 -> 5, comes IN_STOCK) ===");
        inventory.updateStock("Item-A", 5);  // Alice and Carl (customers) get notified

        System.out.println("\n=== Selling Item-B twice (2 -> 1 -> 0, goes OUT_OF_STOCK) ===");
        inventory.sellItem("Item-B");  // 2 -> 1, no notification
        inventory.sellItem("Item-B");  // 1 -> 0, goes out of stock (Managers notified)

        System.out.println("\n=== Restocking Item-B (0 -> 3, comes IN_STOCK) ===");
        inventory.updateStock("Item-B", 3);  // Customers don't care if Item-B comes back in stock (they didn't subscribe)

        System.out.println("\n=== Unsubscribe customer1 and restock Item-A ===");
        inventorySubject.unsubscribe("Item-A", customer1);
        inventory.updateStock("Item-A", 5);  // Only Carl (customer3) gets notified, not Alice
    }
}
