package com.parkinglot.parkingmanager;

import com.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.parkinglot.model.VehicleType;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingAreaManager<T extends ParkingSpot> {
    protected final VehicleType vehicleType;
    protected final List<T> parkingSpots;
    protected ParkingStrategy parkingStrategy;
    
    public ParkingAreaManager(VehicleType vehicleType,List<T> parkingSpots) {
        this.vehicleType = vehicleType;
        this.parkingSpots = parkingSpots;
    }
    
    public ParkingAreaManager(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        this.parkingSpots = new ArrayList<>();
    }
    
    public List<T> getParkingSpots() {
        return parkingSpots;
    }
    
    public abstract boolean addParkingSpot(T parkingSpot);
    
    public abstract boolean removeParkingSpot(T parkingSpot);

    public ParkingSpot findParkingSpot() throws NullPointerException, ParkingSpotNotFoundException {
        if(parkingStrategy == null){
            throw new NullPointerException("Parking strategy is null, please set the strategy first.");
        }
        return this.parkingStrategy.findParkingSpot(this.parkingSpots);
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public abstract void setParkingStrategy(ParkingStrategy parkingStrategy);
}
