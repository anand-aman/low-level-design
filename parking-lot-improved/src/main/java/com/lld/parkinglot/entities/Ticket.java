package com.lld.parkinglot.entities;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Ticket {
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
}