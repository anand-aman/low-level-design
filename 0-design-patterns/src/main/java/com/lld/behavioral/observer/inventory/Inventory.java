package com.lld.behavioral.observer.inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple Inventory store that manages quantities and emits InventoryEvent
 * transitions (IN_STOCK / OUT_OF_STOCK) to the Subject. Note: events do
 * not contain numeric quantities — observers only learn the item and the
 * type of state transition.
 *
 * For learning purposes the Inventory directly constructs events when the
 * stock crosses the zero boundary (0 -> >0 = IN_STOCK, >0 -> 0 = OUT_OF_STOCK).
 */
public class Inventory {
   private final Subject subject;
   private final Map<String, Integer> inventory;

   public Inventory(Subject subject) {
       this.inventory = new HashMap<>();
       this.subject = subject;

       this.inventory.put("Item-A", 1);
       this.inventory.put("Item-B", 2);
       this.inventory.put("Item-C", 3);
       this.inventory.put("Item-D", 0);
       this.inventory.put("Item-E", 0);
   }

   public void sellItem(String item) {
       int currentQuantity = inventory.getOrDefault(item, 0);
       if (currentQuantity > 0) {
           this.inventory.put(item, currentQuantity - 1);
           System.out.println(item + " has been sold.");

           // Notify managers if item goes out of stock
           if (currentQuantity - 1 == 0) {
               InventoryEvent event = new InventoryEvent(item, InventoryEvent.EventType.OUT_OF_STOCK);
               subject.notifyObservers(event);
           }
       } else {
           System.out.println(item + " is out of stock.");
       }
   }

   public void addNewItem(String item, int quantity) {
       inventory.put(item, quantity);
   }

   public void updateStock(String item, int quantity) {
       this.inventory.putIfAbsent(item, 0);
       int previousQuantity = this.inventory.get(item);
       this.inventory.put(item, previousQuantity + quantity);

       // Notify customers if item comes back in stock
       if (previousQuantity == 0) {
           InventoryEvent event = new InventoryEvent(item, InventoryEvent.EventType.IN_STOCK);
           subject.notifyObservers(event);
       }
   }

}
