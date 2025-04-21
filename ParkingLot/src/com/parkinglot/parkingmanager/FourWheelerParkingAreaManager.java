package com.parkinglot.parkingmanager;

import com.parkinglot.parkingspot.FourWheelerParkingSpot;
import com.parkinglot.strategy.ParkingStrategy;

import java.util.List;

public class FourWheelerParkingAreaManager extends ParkingAreaManager<FourWheelerParkingSpot>{
    public FourWheelerParkingAreaManager() {
        super();
        this.parkingStrategy = new ParkNearestToEntrance();
    }

    public FourWheelerParkingAreaManager(List<FourWheelerParkingSpot>  parkingSpots) {
        super(parkingSpots);
        this.parkingStrategy = new ParkNearestToEntrance();
    }

    @Override
    public boolean addParkingSpot(FourWheelerParkingSpot parkingSpot){
        return this.parkingSpots.add(parkingSpot);
    }

    @Override
    public boolean removeParkingSpot(FourWheelerParkingSpot parkingSpot){
        return this.parkingSpots.remove(parkingSpot);
    }

    @Override
    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }
}
