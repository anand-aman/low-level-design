package com.lld.parkinglot;

import lombok.Builder;

@Builder
public class Vehicle {
    private String licenseNumber;
    private VehicleType vehicleType;
}


