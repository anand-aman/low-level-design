package com.lld.creational.builder;

public class BuilderDemo{
    public static void main(String[] args) {
        MyRequest request = new MyRequest.Builder().name("Request 1")
                .header("Header 1")
                .path("/path/to/request")
                .build();
        System.out.println("Request Name: " + request);
    }
}