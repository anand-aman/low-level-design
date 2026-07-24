package com.lld.behavioral.observer.editor;

import java.util.ArrayList;
import java.util.List;

public class LoggingListener implements EventListener{
    private List<String> log;

    public LoggingListener() {
        log = new ArrayList<>();
    }

    @Override
    public void update(String filename) {
        log.add("File " + filename + " has been updated.");
        System.out.println("LoggingListener: File " + filename + " has been updated. log size: " + log.size());
    }
}
