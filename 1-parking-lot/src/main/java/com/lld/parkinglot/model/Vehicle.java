package com.lld.parkinglot.model;

import lombok.Builder;

@Builder
public class Vehicle {
    private String licenseNumber;
    private VehicleType vehicleType;
}


