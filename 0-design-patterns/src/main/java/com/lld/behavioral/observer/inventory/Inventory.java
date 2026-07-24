package com.lld.behavioral.observer.inventory;

import java.util.HashMap;
import java.util.Map;

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

       if (previousQuantity == 0) {
           subject.notifyObservers(item, item +" is back in stock!");
       }
   }

}
