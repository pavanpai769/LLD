package com.parkinglot.parkingspot;

import com.parkinglot.model.VehicleType;

public class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(int id,double price) {
        super(id,false, VehicleType.TwoWheeler,null,price);
    }
}
