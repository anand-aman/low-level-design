package com.lld.structural.decorator;

/**
 * Concrete component that implements {@link DataSource}.
 *
 * Note: For learning/demo purposes this class simulates a file-backed data
 * source by keeping `storedData` in memory. In a production or extended demo
 * you might implement actual file I/O using java.nio or java.io APIs.
 */
public class FileDataSource implements DataSource{

    private String storedData;

    public FileDataSource() {
        // simulate empty file
        storedData = "";
    }

    /**
     * Write data to the (simulated) file.
     * In this demo we simply store the string in memory and print a message.
     */
    @Override
    public void writeData(String data) {
        storedData = data;
        System.out.println("Writing data to file: " + data);
    }

    /** Read data previously written to this data source (or decorated chain). */
    @Override
    public String readData() {
        return storedData;
    }
}
