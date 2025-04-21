package com.parkinglot.parkingmanager;

import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingAreaManager<T extends ParkingSpot> {
    protected final List<T> parkingSpots;
    protected ParkingStrategy parkingStrategy;
    
    public ParkingAreaManager(List<T> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
    
    public ParkingAreaManager() {
        this.parkingSpots = new ArrayList<>();
    }
    
    public List<T> getParkingSpots() {
        return parkingSpots;
    }
    
    public abstract boolean addParkingSpot(T parkingSpot);
    
    public abstract boolean removeParkingSpot(T parkingSpot);

    public ParkingSpot findParkingSpot() throws NullPointerException{
        if(parkingStrategy == null){
            throw new NullPointerException("Parking strategy is null, please set the strategy first.");
        }
        return this.parkingStrategy.findParkingSpot(this.parkingSpots);
    }

    public abstract void setParkingStrategy(ParkingStrategy parkingStrategy);
}
