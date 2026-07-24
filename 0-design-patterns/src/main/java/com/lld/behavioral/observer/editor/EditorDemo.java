package com.lld.behavioral.observer.editor;

public class EditorDemo {
    public static void main(String[] args) throws InterruptedException {
        EventManager eventManager = new EventManager();
        Editor editor = new Editor(eventManager);

        EventListener loggingListener = new LoggingListener();
        EventListener emailListener = new EmailListener("user@gmail.com");

        eventManager.subscribe(EventType.OPEN, loggingListener);
        eventManager.subscribe(EventType.SAVE, emailListener);

        editor.openFile("test.txt");

        System.out.println("------------------");
        Thread.sleep(5000);

        editor.saveFile("test.txt");
    }
}
