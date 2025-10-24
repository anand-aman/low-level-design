package com.lld.parkinglot;

import com.lld.parkinglot.entities.PaymentStatus;
import com.lld.parkinglot.entities.Ticket;
import com.lld.parkinglot.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ParkingLotManager {

    private ParkingLot parkingLot;

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        return parkingLot.findAvailableSpot(vehicle);
    }

    public Ticket bookSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.occupySpot(vehicle);
        return issueTicket(vehicle, spot);
    }

    public void releaseSpot(Ticket ticket) {
        ticket.getParkingSpot().releaseSpot();
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
