package com.lld.parkinglot;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParkingSpot {
    private int id;
    private boolean isAvailable;
    private int price;
    private Vehicle parkedVehicle;

    public void parkVehicle(Vehicle vehicle) {
        parkedVehicle = vehicle;
        isAvailable = false;
    }

    public void unparkVehicle() {
        parkedVehicle = null;
        isAvailable = true;
    }
}
