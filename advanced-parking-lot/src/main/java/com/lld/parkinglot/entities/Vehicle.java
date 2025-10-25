package com.lld.parkinglot.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Vehicle {
    private String licenseNumber;
    private VehicleType vehicleType;
}


