package com.parkinglot.parkingspot;

import com.parkinglot.model.VehicleType;

public class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(String id,double price) {
        super(id,false, VehicleType.TwoWheeler,null,price);
    }
}
