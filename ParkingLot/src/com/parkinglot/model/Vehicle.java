package com.parkinglot.model;

public class Vehicle {
    private final String id;
    private final VehicleType vehicleType;

    public Vehicle(String id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return this.id;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
