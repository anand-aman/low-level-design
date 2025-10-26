package com.lld.parkinglot.strategy;

import com.lld.parkinglot.entities.ParkingSpot;
import com.lld.parkinglot.entities.VehicleType;

import java.util.List;

public class FarthestFirstStrategy implements ParkingStrategy{

    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpots, VehicleType vehicleType) {
        for (int i = parkingSpots.size() - 1; i >= 0; i--) {
            if (parkingSpots.get(i).isAvailable() && parkingSpots.get(i).getAllowedVehicleTypes().contains(vehicleType)) {
                return parkingSpots.get(i);
            }
        }
        return null;
    }
}
