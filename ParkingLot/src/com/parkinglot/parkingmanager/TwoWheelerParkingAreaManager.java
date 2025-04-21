package com.parkinglot.parkingmanager;

import com.parkinglot.parkingspot.TwoWheelerParkingSpot;
import com.parkinglot.strategy.ParkAnyWhere;
import com.parkinglot.strategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerParkingAreaManager extends ParkingAreaManager<TwoWheelerParkingSpot> {

    public TwoWheelerParkingAreaManager(List<TwoWheelerParkingSpot> parkingSpots) {
        super(parkingSpots);
    }

    public TwoWheelerParkingAreaManager() {
        super();
    }

    @Override
    public boolean addParkingSpot(TwoWheelerParkingSpot parkingSpot){
        return this.parkingSpots.add(parkingSpot);
    }

    @Override
    public boolean removeParkingSpot(TwoWheelerParkingSpot parkingSpot){
        return this.parkingSpots.remove(parkingSpot);
    }

    @Override
    public void setParkingStrategy(ParkingStrategy  parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }


}
