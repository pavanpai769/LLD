package com.parkinglot.parkingspot;

import com.parkinglot.model.VehicleType;

public class FourWheelerParkingSpot extends ParkingSpot {
    public FourWheelerParkingSpot(int id,double price) {
        super(id,false, VehicleType.FourWheeler,null,price);
    }
}
