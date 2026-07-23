package com.lld.structural.decorator;

/**
 * Simple demo showing composition of decorators around a concrete component.
 *
 * Two scenarios are shown:
 *  1) CompressionDecorator wraps FileDataSource, then EncryptionDecorator wraps the compression.
 *  2) EncryptionDecorator wraps FileDataSource, then CompressionDecorator wraps the encryption.
 *
 * The output demonstrates how ordering of decorators affects the stored and returned data
 * and that decorators are interchangeable and composable because they implement the same
 * {@link DataSource} interface.
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        DataSource baseDataSource = new FileDataSource();

        // Scenario 1: compress first, then encrypt the compressed result
        System.out.println("--- Scenario 1: Encryption(Compression(File)) ---");
        DataSource compressedDataSource = new CompressionDecorator(baseDataSource);
        DataSource encryptedDataSource = new EncryptionDecorator(compressedDataSource);

        encryptedDataSource.writeData("Hello, World!");
        System.out.println("Read back: " + encryptedDataSource.readData());

        System.out.println();

        // Scenario 2: encrypt first, then compress the encrypted result
        System.out.println("--- Scenario 2: Compression(Encryption(File)) ---");
        DataSource encryptedDataSource2 = new EncryptionDecorator(baseDataSource);
        DataSource compressedDataSource2 = new CompressionDecorator(encryptedDataSource2);
        compressedDataSource2.writeData("Hello, Aman!");
        System.out.println("Read back: " + compressedDataSource2.readData());
    }
}
