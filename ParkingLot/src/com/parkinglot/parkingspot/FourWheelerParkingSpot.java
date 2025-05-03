package com.parkinglot.parkingspot;

import com.parkinglot.model.VehicleType;

public class FourWheelerParkingSpot extends ParkingSpot {
    public FourWheelerParkingSpot(String id,double price) {
        super(id,false, VehicleType.FourWheeler,null,price);
    }
}
