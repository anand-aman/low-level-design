package com.lld.parkinglot;

public class EntranceGate {
    private ParkingLotManager parkingLotManager;

    public ParkingSpot findAvailableParkingSpot(Vehicle vehicle) {
        return parkingLotManager.findAvailableParkingSpot(vehicle);
    }

    public Ticket bookParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        return parkingLotManager.issueTicket(vehicle, parkingSpot);
    }


}
