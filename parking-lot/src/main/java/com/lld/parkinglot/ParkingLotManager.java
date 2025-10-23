package com.lld.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ParkingLotManager {

    private List<ParkingSpot> parkingSpotList;

    public void addParkingSpot(ParkingSpot spot) {

    }

    public void removeParkingSpot(ParkingSpot spot) {

    }

    public ParkingSpot findAvailableParkingSpot() {
        return parkingSpotList.getFirst();
    }

    public void parkVehicle(Vehicle vehicle) {

    }

    public void unParkVehicle(Vehicle vehicle) {

    }
}
