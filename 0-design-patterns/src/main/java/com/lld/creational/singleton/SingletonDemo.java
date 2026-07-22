package com.lld.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        DatabaseConnection databaseConnection1 = DatabaseConnection.getInstance();

        System.out.println(databaseConnection==databaseConnection1);
    }
}
