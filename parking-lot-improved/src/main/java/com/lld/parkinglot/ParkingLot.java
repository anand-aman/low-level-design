package com.lld.parkinglot;

import com.lld.parkinglot.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ParkingLot {

    private List<ParkingSpot> parkingSpotList;

    public void addSpot(ParkingSpot spot) {
        parkingSpotList.add(spot);
    }

    public void removeSpot(ParkingSpot spot) {
        parkingSpotList.remove(spot);
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        return parkingSpotList.stream()
                .filter(ParkingSpot::isAvailable)
                .findFirst()
                .map(parkingSpot -> {
                    System.out.println("Available spot for vehicle " + vehicle.getLicenseNumber() + " is Spot ID: " + parkingSpot.getId());
                    return parkingSpot;
                })
                .orElse(null);
    }

}
