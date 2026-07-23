package com.lld.structural.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        DataSource baseDataSource = new FileDataSource("file.txt");
        DataSource compressedDataSource = new CompressionDecorator(baseDataSource);
        DataSource encryptedDataSource = new EncryptionDecorator(compressedDataSource);

        encryptedDataSource.writeData("Hello, World!");
        System.out.println(encryptedDataSource.readData());


        DataSource encryptedDataSource2 = new EncryptionDecorator(baseDataSource);
        DataSource compressedDataSource2 = new CompressionDecorator(encryptedDataSource2);
        compressedDataSource2.writeData("Hello, Aman!");
        System.out.println(compressedDataSource2.readData());
    }
}
