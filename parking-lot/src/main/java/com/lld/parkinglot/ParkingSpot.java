package com.lld.parkinglot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ParkingSpot {
    private int id;
    private boolean isAvailable;
    private int price;
    private Vehicle vehicle;

    public void parkVehicle(Vehicle v) {
        vehicle = v;
        isAvailable = false;
    }

    public void unparkVehicle(Vehicle vehicle) {
        vehicle = null;
        isAvailable = true;
    }
}
