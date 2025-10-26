package com.lld.parkinglot.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParkingSpot {
    private int id;
    private boolean isAvailable;
    private int price;
    private Vehicle parkedVehicle;

    public void occupySpot(Vehicle vehicle) {
        parkedVehicle = vehicle;
        isAvailable = false;
    }

    public void releaseSpot() {
        parkedVehicle = null;
        isAvailable = true;
    }
}
