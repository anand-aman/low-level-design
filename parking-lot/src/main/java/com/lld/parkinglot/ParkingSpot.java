package com.lld.parkinglot;

public class ParkingSpot {
    private int id;
    private boolean isEmpty;
    private int price;
    private Vehicle vehicle;

    public ParkingSpot() {

    }

    public void parkVehicle(Vehicle v) {
        vehicle = v;
        isEmpty = false;
    }

    public void unparkVehicle(Vehicle vehicle) {
        vehicle = null;
        isEmpty = true;
    }
}
