package com.lld.behavioral.observer.editor;

import java.util.HashMap;
import java.util.List;

public class EventManager {
    private HashMap<EventType, List<EventListener>> listeners;

    public EventManager() {
        listeners = new HashMap<>();
    }

    public void subscribe(EventType eventType, EventListener eventListener) {
        listeners.putIfAbsent(eventType, new java.util.ArrayList<>());
        listeners.get(eventType).add(eventListener);
    }

    public void unsubscribe(EventType eventType, EventListener eventListener) {
        listeners.get(eventType).remove(eventListener);
    }

    public void notify(EventType eventType, String message) {
        System.out.println("Notifying listeners of event: " + eventType);

        for (EventListener listener : listeners.get(eventType)) {
            listener.update(message);
        }
    }
}
