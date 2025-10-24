package com.lld.parkinglot;

import com.lld.parkinglot.entities.PaymentStatus;
import com.lld.parkinglot.entities.Ticket;
import com.lld.parkinglot.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ParkingLotManager {

    private List<ParkingSpot> parkingSpotList;

    public void addSpot(ParkingSpot spot) {
        parkingSpotList.add(spot);
    }

    public void removeSpot(ParkingSpot spot) {
        parkingSpotList.remove(spot);
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        return parkingSpotList.stream()
                .filter(ParkingSpot::isAvailable)
                .findFirst()
                .map(parkingSpot -> {
                    System.out.println("Available spot for vehicle " + vehicle.getLicenseNumber() + " is Spot ID: " + parkingSpot.getId());
                    return parkingSpot;
                })
                .orElse(null);
    }

    public Ticket bookSpot(Vehicle vehicle, ParkingSpot spot) {
        return issueTicket(vehicle, spot);
    }

    private Ticket issueTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return Ticket.builder()
                .parkingSpot(parkingSpot)
                .vehicle(vehicle)
                .entryTime(LocalDateTime.now())
                .build();
    }

    public double calculateParkingFee(Ticket ticket) {
        Duration duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
        long totalSeconds = duration.getSeconds();
        double hours = Math.ceil(totalSeconds / 3600.0);

        return ticket.getParkingSpot().getPrice() * hours;
    }

    public PaymentStatus processPayment(Ticket ticket, double amount) {
        System.out.println("Payment Received in Cash");
        return PaymentStatus.SUCCESS;
    }

    public void parkVehicle(ParkingSpot spot, Vehicle vehicle) {
        System.out.println("Vehicle parked at spot ID: " + spot.getId());
        spot.occupySpot(vehicle);
    }

    public void unparkVehicle(ParkingSpot spot) {
        System.out.println("Vehicle exited. Parking spot " +spot.getId() +" freed.");
        spot.releaseSpot();
    }
}
