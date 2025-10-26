package com.lld.parkinglot;

import com.lld.parkinglot.entities.*;

import java.util.List;

public class ParkingLotDemo {
    public static void main(String[] args) {

        ParkingSpot spot1 = ParkingSpot.builder().id(1).isAvailable(true).price(10).build();
        ParkingSpot spot2 = ParkingSpot.builder().id(2).isAvailable(true).price(15).build();
        ParkingSpot spot3 = ParkingSpot.builder().id(3).isAvailable(true).price(20).build();
        List<ParkingSpot> parkingSpotList = List.of(spot1, spot2, spot3);

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingSpotList);

        EntranceGate entranceGate = new EntranceGate(parkingLotManager);
        ExitGate exitGate = new ExitGate(parkingLotManager);

        Vehicle vehicle = Vehicle.builder().licenseNumber("KA01").vehicleType(VehicleType.TWO_WHEELER).build();

        Ticket ticket = entranceGate.enter(vehicle);
        parkingLotManager.parkVehicle(ticket.getParkingSpot(), vehicle);

        PaymentStatus paymentStatus = exitGate.processExit(ticket);
        if (paymentStatus == PaymentStatus.SUCCESS) {
            parkingLotManager.unparkVehicle(ticket.getParkingSpot());
        }

    }
}
