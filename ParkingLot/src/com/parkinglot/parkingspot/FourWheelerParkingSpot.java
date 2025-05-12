package com.parkinglot.parkingspot;

import com.parkinglot.model.vehicle.VehicleType;

public class FourWheelerParkingSpot extends ParkingSpot {
    public FourWheelerParkingSpot(String id) {
        super(id, VehicleType.FourWheeler);
    }
}
