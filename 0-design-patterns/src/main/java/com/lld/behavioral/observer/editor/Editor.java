package com.lld.behavioral.observer.editor;

public class Editor {
    private EventManager events;

    public Editor(EventManager events) {
        this.events = events;
    }

    public void openFile(String path) {
        System.out.println("Opening file: " + path);
        events.notify(EventType.OPEN, path);
    }

    public void saveFile(String path) {
        System.out.println("Saving file: " + path);
        events.notify(EventType.SAVE, path);
    }
}
