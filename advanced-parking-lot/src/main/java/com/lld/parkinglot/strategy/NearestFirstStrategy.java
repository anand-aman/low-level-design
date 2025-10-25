package com.lld.parkinglot.strategy;

import com.lld.parkinglot.entities.ParkingSpot;
import com.lld.parkinglot.entities.VehicleType;

import java.util.List;

public class NearestFirstStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpots, VehicleType vehicleType) {
        return parkingSpots.stream()
                .filter(ParkingSpot::isAvailable)
                .filter(spot -> spot.getAllowedVehicleTypes().contains(vehicleType))
                .findFirst()
                .orElse(null);
    }
}
