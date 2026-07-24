package com.lld.behavioral.observer.editor;

public class EmailListener implements EventListener{
    private String email;

    public EmailListener(String email) {
        this.email = email;
    }


    @Override
    public void update(String filename) {
        System.out.println("Email to " + email + ": Someone has performed an action on the file: " + filename);
    }
}
