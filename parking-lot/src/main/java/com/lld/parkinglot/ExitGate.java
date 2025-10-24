package com.lld.parkinglot;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
public class ExitGate {
    private ParkingLotManager parkingLotManager;

    public void processExit(Ticket ticket) {
        double parkingFee = calculateParkingFee(ticket);
        boolean paymentStatus = processPayment(ticket, parkingFee);

        if (paymentStatus) {
            updateParkingSpotAvailability(ticket);
            System.out.println("Exit Processed Successfully. Please Exit the Parking Lot.");
        } else {
            System.out.println("Payment Failed. Please Try Again.");
        }
    }

    private double calculateParkingFee(Ticket ticket) {
        Duration duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
        long totalSeconds = duration.getSeconds();
        double hours = Math.ceil(totalSeconds / 3600.0);

        return ticket.getParkingSpot().getPrice() * hours;
    }

    private boolean processPayment(Ticket ticket, double amount) {
        System.out.println("Payment Received in Cash");
        return true;
    }

    private void updateParkingSpotAvailability(Ticket ticket) {
        parkingLotManager.unparkVehicle(ticket.getParkingSpot(), ticket.getVehicle());
    }
}
