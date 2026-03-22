package com.lld.parkinglot;

import com.lld.parkinglot.model.Ticket;
import com.lld.parkinglot.model.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EntranceGate {
    private ParkingLotManager parkingLotManager;

    public ParkingSpot findAvailableParkingSpot(Vehicle vehicle) {
        return parkingLotManager.findAvailableParkingSpot(vehicle);
    }

    public Ticket bookParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        return parkingLotManager.issueTicket(vehicle, parkingSpot);
    }

}
