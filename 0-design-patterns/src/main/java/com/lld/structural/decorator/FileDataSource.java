package com.lld.structural.decorator;

public class FileDataSource implements DataSource{

    private String fileName;
    private String storedData;

    public FileDataSource(String fileName) {
        this.fileName = fileName;
        storedData = "";
    }

    @Override
    public void writeData(String data) {
        storedData = data;
        System.out.println("Writing data to file: " + data);
    }

    @Override
    public String readData() {
        return storedData;
    }
}
