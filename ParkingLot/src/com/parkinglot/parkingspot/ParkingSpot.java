package com.parkinglot.parkingspot;

import com.parkinglot.model.Vehicle;
import com.parkinglot.model.VehicleType;

public abstract class ParkingSpot {
    public int id;
    public boolean isEmpty;
    public VehicleType vehicleType;
    public Vehicle vehicle;
    public double price;

    public ParkingSpot(int id,boolean isEmpty,VehicleType vehicleType,Vehicle vehicle,double price){
        this.id=id;
        this.isEmpty=isEmpty;
        this.vehicleType=vehicleType;
        this.vehicle=vehicle;
        this.price=price;
    }
}
