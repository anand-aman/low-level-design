package com.lld.behavioral.observer.inventory;

/**
 * Observer contract: receives an {@link InventoryEvent} and decides whether
 * to act based on the event type. For the simple sample, observers filter
 * IN_STOCK vs OUT_OF_STOCK events inside their {@code update} method.
 */
public interface Observer {
    void update(InventoryEvent event);
}
