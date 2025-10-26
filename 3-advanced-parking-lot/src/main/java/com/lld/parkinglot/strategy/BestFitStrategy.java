package com.lld.parkinglot.strategy;

import com.lld.parkinglot.entities.ParkingSpot;
import com.lld.parkinglot.entities.VehicleType;

import java.util.List;

public class BestFitStrategy implements ParkingStrategy{

    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpots, VehicleType vehicleType) {
        return parkingSpots.stream()
                .filter(ParkingSpot::isAvailable)
                .filter(spot -> isBestFit(spot, vehicleType))
                .findFirst()
                .orElse(null);
    }

    private boolean isBestFit(ParkingSpot spot, VehicleType vehicleType) {
        switch (vehicleType) {
            case SMALL:
                return spot.getAllowedVehicleTypes().contains(VehicleType.SMALL)
                        && spot.getAllowedVehicleTypes().size() == 1;
            case MEDIUM:
                return spot.getAllowedVehicleTypes().contains(VehicleType.MEDIUM)
                        && spot.getAllowedVehicleTypes().size() == 2;
            case LARGE:
                return spot.getAllowedVehicleTypes().contains(VehicleType.LARGE)
                        && spot.getAllowedVehicleTypes().size() == 3;
            default:
                return false;
        }
    }
}
