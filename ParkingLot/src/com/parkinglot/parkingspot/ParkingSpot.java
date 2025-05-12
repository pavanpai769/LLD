package com.parkinglot.parkingspot;

import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.model.vehicle.VehicleType;

public abstract class ParkingSpot {
    private final String id;
    private boolean isEmpty;
    private final VehicleType vehicleType;
    private Vehicle vehicle;
    private double price;

    public ParkingSpot(String id,VehicleType vehicleType){
        this.id=id;
        this.isEmpty=true;
        this.vehicleType=vehicleType;
    }

    public void park(Vehicle vehicle){
        this.vehicle=vehicle;
        this.isEmpty= false;
    }

    public void unpark(){
        this.vehicle= null;
        this.isEmpty= true;
    }

    public String getId() {
        return id;
    }

    public boolean isEmpty() {
        return isEmpty;
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

}
