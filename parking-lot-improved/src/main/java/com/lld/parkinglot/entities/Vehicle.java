package com.lld.parkinglot.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Vehicle {
    private String licenseNumber;
    private VehicleType vehicleType;
}


