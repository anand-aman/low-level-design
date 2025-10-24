package com.lld.parkinglot;

import com.lld.parkinglot.entities.Ticket;
import com.lld.parkinglot.entities.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EntranceGate {
    private ParkingLotManager manager;

    public Ticket enter(Vehicle vehicle) {
        ParkingSpot spot = manager.findAvailableSpot(vehicle);
        return manager.bookSpot(vehicle, spot);
    }

}
