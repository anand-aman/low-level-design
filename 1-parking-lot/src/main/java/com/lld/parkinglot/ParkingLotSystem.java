package com.lld.parkinglot;

import java.util.List;

public class ParkingLotSystem {
    public static void main(String[] args) {

        ParkingSpot spot1 = ParkingSpot.builder().id(1).isAvailable(true).price(10).build();
        ParkingSpot spot2 = ParkingSpot.builder().id(2).isAvailable(true).price(15).build();
        ParkingSpot spot3 = ParkingSpot.builder().id(3).isAvailable(true).price(20).build();
        List<ParkingSpot> parkingSpotList = List.of(spot1, spot2, spot3);

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingSpotList);
        EntranceGate entranceGate = new EntranceGate(parkingLotManager);
        ExitGate exitGate = new ExitGate(parkingLotManager);

        Vehicle vehicle = Vehicle.builder().licenseNumber("KA01").vehicleType(VehicleType.TWO_WHEELER).build();

        ParkingSpot parkingSpot = entranceGate.findAvailableParkingSpot(vehicle);
        if (parkingSpot != null) {

            Ticket ticket = entranceGate.bookParkingSpot(vehicle, parkingSpot);
            System.out.println("Parking spot booked. Ticket issued.");
            parkingLotManager.parkVehicle(parkingSpot, vehicle);

            parkingLotManager.unparkVehicle(parkingSpot, vehicle);
            exitGate.processExit(ticket);
            System.out.println("Vehicle exited. Parking spot freed.");
        } else {
            System.out.println("No available parking spots.");
        }
    }
}
