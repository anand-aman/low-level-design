package com.lld.parkinglot.strategy;

import com.lld.parkinglot.entities.ParkingSpot;
import com.lld.parkinglot.entities.VehicleType;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingSpot> parkingSpots, VehicleType vehicleType);
}
