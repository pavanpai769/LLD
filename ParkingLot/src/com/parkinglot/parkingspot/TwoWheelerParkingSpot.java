package com.parkinglot.parkingspot;

import com.parkinglot.model.vehicle.VehicleType;

public class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(String id) {
        super(id, VehicleType.TwoWheeler);
    }
}
