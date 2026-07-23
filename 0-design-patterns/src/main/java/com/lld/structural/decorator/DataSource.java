package com.lld.structural.decorator;

public interface DataSource {
    void writeData(String data);
    String readData();
}
