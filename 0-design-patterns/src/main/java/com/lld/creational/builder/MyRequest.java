package com.lld.creational.builder;

public class MyRequest {
    private String name;
    private String header;
    private String path;

    private MyRequest(){

    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public static class Builder{
        MyRequest request;

        public Builder(){
            request = new MyRequest();
        }

        public Builder name(String name) {
            this.request.name = name;
            return this;
        }

        public Builder header(String header) {
            this.request.header = header;
            return this;
        }

        public Builder path(String path) {
            this.request.path = path;
            return this;
        }

        public MyRequest build() {
            return this.request;
        }

    }
}