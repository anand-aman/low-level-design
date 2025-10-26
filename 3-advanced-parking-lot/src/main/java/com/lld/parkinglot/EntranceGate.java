package com.lld.parkinglot;

import com.lld.parkinglot.entities.ParkingSpot;
import com.lld.parkinglot.entities.Ticket;
import com.lld.parkinglot.entities.Vehicle;
import com.lld.parkinglot.strategy.ParkingStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EntranceGate {
    private ParkingLotManager manager;

    public Ticket enter(Vehicle vehicle, String strategyType) {
        ParkingStrategy strategy = ParkingStrategyFactory.getStrategy(strategyType);
        ParkingSpot spot = manager.findAvailableSpot(vehicle, strategy);
        return manager.bookSpot(vehicle, spot);
    }

}
