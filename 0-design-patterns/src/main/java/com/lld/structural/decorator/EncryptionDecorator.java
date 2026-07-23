package com.lld.structural.decorator;

// It simulates encryption by wrapping the string with markers. Not real encryption.
public class EncryptionDecorator implements DataSource{

    private DataSource wrapped;

    public EncryptionDecorator(DataSource wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void writeData(String data) {
        String encryptedData = "Encrypted:[" + data + "]";
        wrapped.writeData(encryptedData);
    }

    @Override
    public String readData() {
        String data = wrapped.readData();
        String decryptedData = data != null && data.length() > 10 ? data.substring(11, data.length()-1) : null;
        return decryptedData;
    }
}
