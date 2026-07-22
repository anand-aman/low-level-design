package com.lld.creational.singleton;

public class DatabaseConnection {
    public static DatabaseConnection instance;

    private DatabaseConnection() {
        System.out.println("Database connection established");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }


}
