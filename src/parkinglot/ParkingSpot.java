package parkinglot;

import parkinglot.vehicle.Vehicle;

public class ParkingSpot {
    private int id;
    private boolean isEmpty;
    private Vehicle vehicle;
    private int price;

    public ParkingSpot() {

    }

    public void parkVehicle(Vehicle v) {
        vehicle = v;
        isEmpty = false;
    }

    public void unparkVehicle(Vehicle vehicle) {
        vehicle = null;
        isEmpty = true;
    }
}
