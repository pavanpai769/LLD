package com.parkinglot.strategy;

import com.parkinglot.parkingspot.ParkingSpot;

import java.util.List;

public class ParkAnyWhere implements ParkingStrategy {

    @Override
    public ParkingSpot findParkingSpot(List<? extends ParkingSpot> parkingSpots) {
        return parkingSpots.stream()
                .filter(parkingSpot -> parkingSpot.isEmpty)
                .findFirst()
                .orElse(null);
    }
}
