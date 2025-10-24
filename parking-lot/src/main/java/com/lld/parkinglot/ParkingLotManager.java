package com.lld.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ParkingLotManager {

    private List<ParkingSpot> parkingSpotList;

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpotList.add(spot);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        parkingSpotList.remove(spot);
    }

    public ParkingSpot findAvailableParkingSpot(Vehicle vehicle) {
        return parkingSpotList.stream()
                .filter(ParkingSpot::isAvailable)
                .findFirst()
                .orElse(null);
    }

    public Ticket issueTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return Ticket.builder()
                .parkingSpot(parkingSpot)
                .vehicle(vehicle)
                .entryTime(LocalDateTime.now())
                .build();
    }

    public void parkVehicle(ParkingSpot parkingSpot, Vehicle vehicle) {
        parkingSpot.parkVehicle(vehicle);
    }

    public void unparkVehicle(ParkingSpot parkingSpot, Vehicle vehicle) {
        parkingSpot.unparkVehicle(vehicle);
    }
}
