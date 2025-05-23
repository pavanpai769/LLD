package com.parkinglot.parkingmanager;

import com.parkinglot.model.vehicle.VehicleType;
import com.parkinglot.parkingspot.TwoWheelerParkingSpot;
import com.parkinglot.strategy.parking.ParkingStrategy;

import java.util.List;

public class TwoWheelerParkingAreaManager extends ParkingAreaManager<TwoWheelerParkingSpot> {

    public TwoWheelerParkingAreaManager(List<TwoWheelerParkingSpot> parkingSpots) {
        super(VehicleType.TwoWheeler,parkingSpots);
    }

    public TwoWheelerParkingAreaManager() {
        super(VehicleType.TwoWheeler);
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
