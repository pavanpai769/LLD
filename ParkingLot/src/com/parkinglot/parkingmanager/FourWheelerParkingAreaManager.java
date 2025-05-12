package com.parkinglot.parkingmanager;

import com.parkinglot.model.vehicle.VehicleType;
import com.parkinglot.parkingspot.FourWheelerParkingSpot;
import com.parkinglot.strategy.parking.ParkAnyWhere;
import com.parkinglot.strategy.parking.ParkingStrategy;

import java.util.List;

public class FourWheelerParkingAreaManager extends ParkingAreaManager<FourWheelerParkingSpot>{
    public FourWheelerParkingAreaManager() {
        super(VehicleType.FourWheeler);
        this.parkingStrategy = new ParkAnyWhere();
    }

    public FourWheelerParkingAreaManager(List<FourWheelerParkingSpot>  parkingSpots) {
        super(VehicleType.FourWheeler,parkingSpots);
        this.parkingStrategy = new ParkAnyWhere();
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
