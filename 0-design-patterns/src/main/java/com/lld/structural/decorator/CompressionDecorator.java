package com.lld.structural.decorator;

public class CompressionDecorator implements DataSource{

    private DataSource wrapped;

    public CompressionDecorator(DataSource wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void writeData(String data) {
        String encryptedData = "Compressed:(" + data + ")";
        wrapped.writeData(encryptedData);
    }

    @Override
    public String readData() {
        String data = wrapped.readData();
        String unCompressedData = data != null && data.length() > 11 ? data.substring(12, data.length()-1) : null;
        return unCompressedData;
    }
}
