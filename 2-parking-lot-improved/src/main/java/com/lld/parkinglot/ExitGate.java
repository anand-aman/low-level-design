package com.lld.parkinglot;

import com.lld.parkinglot.entities.PaymentStatus;
import com.lld.parkinglot.entities.Ticket;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExitGate {
    private ParkingLotManager manager;

    public PaymentStatus processExit(Ticket ticket) {
        double parkingFee = manager.calculateParkingFee(ticket);
        PaymentStatus paymentStatus = manager.processPayment(ticket, parkingFee);

        if (PaymentStatus.SUCCESS.equals(paymentStatus)) {
            System.out.println("Exit Processed Successfully. Please Exit the Parking Lot.");
        } else {
            System.out.println("Payment Failed. Please Try Again.");
        }

        return paymentStatus;
    }

}
