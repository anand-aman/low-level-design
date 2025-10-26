package com.lld.parkinglot;

import com.lld.parkinglot.strategy.BestFitStrategy;
import com.lld.parkinglot.strategy.FarthestFirstStrategy;
import com.lld.parkinglot.strategy.NearestFirstStrategy;
import com.lld.parkinglot.strategy.ParkingStrategy;

public class ParkingStrategyFactory {
    public static ParkingStrategy getStrategy(String strategyType) {
        switch (strategyType.toUpperCase()) {
            case "NEAREST_FIRST":
                return new NearestFirstStrategy();
            case "FARTHEST_FIRST":
                return new FarthestFirstStrategy();
            case "BEST_FIT":
                return new BestFitStrategy();
            default:
                throw new IllegalArgumentException("Unknown strategy type: " + strategyType);
        }
    }
}
