package com.lld.parkinglot;

import com.lld.parkinglot.entities.*;

import java.util.List;

public class ParkingLotDemo {
    public static void main(String[] args) throws InterruptedException {

        List<VehicleType> smallVehicleTypes = List.of(VehicleType.SMALL);
        List<VehicleType> mediumVehicleTypes = List.of(VehicleType.SMALL, VehicleType.MEDIUM);
        List<VehicleType> largeVehicleTypes = List.of(VehicleType.SMALL, VehicleType.MEDIUM, VehicleType.LARGE);

        ParkingSpot spot1 = ParkingSpot.builder().id(1).isAvailable(true).allowedVehicleTypes(smallVehicleTypes).price(10).build();
        ParkingSpot spot2 = ParkingSpot.builder().id(2).isAvailable(true).allowedVehicleTypes(mediumVehicleTypes).price(15).build();
        ParkingSpot spot3 = ParkingSpot.builder().id(3).isAvailable(true).allowedVehicleTypes(largeVehicleTypes).price(25).build();
        ParkingSpot spot4 = ParkingSpot.builder().id(4).isAvailable(true).allowedVehicleTypes(smallVehicleTypes).price(5).build();
        List<ParkingSpot> parkingSpotList = List.of(spot1, spot2, spot3);

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingSpotList);

        EntranceGate entranceGate = new EntranceGate(parkingLotManager);
        ExitGate exitGate = new ExitGate(parkingLotManager);

        Vehicle vehicle = Vehicle.builder().licenseNumber("KA01").vehicleType(VehicleType.SMALL).build();

        Ticket ticket = entranceGate.enter(vehicle, "BEST_FIT");
        System.out.println(ticket.toString());
        parkingLotManager.parkVehicle(ticket.getParkingSpot(), vehicle);

        Thread.sleep(2000);

        PaymentStatus paymentStatus = exitGate.processExit(ticket);
        if (paymentStatus == PaymentStatus.SUCCESS) {
            parkingLotManager.unparkVehicle(ticket.getParkingSpot());
        }

    }
}
