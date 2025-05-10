package com.parkinglot.parkingspot;

import com.parkinglot.model.Vehicle;
import com.parkinglot.model.VehicleType;

public abstract class ParkingSpot {
    private final String id;
    private boolean isEmpty;
    private final VehicleType vehicleType;
    private Vehicle vehicle;
    private final double price;

    public ParkingSpot(String id,boolean isEmpty,VehicleType vehicleType,Vehicle vehicle,double price){
        this.id=id;
        this.isEmpty=isEmpty;
        this.vehicleType=vehicleType;
        this.vehicle=vehicle;
        this.price=price;
    }

    public void park(Vehicle vehicle){
        this.vehicle=vehicle;
        this.isEmpty= true;
    }


    public String getId() {
        return id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getPrice() {
        return price;
    }
}
