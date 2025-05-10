package com.parkinglot.strategy;

import com.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.parkinglot.parkingspot.ParkingSpot;

import java.util.List;

public class ParkAnyWhere implements ParkingStrategy {

    @Override
    public ParkingSpot findParkingSpot(List<? extends ParkingSpot> parkingSpots) throws ParkingSpotNotFoundException {
        return parkingSpots.stream()
                .filter(ParkingSpot::isEmpty)
                .findFirst()
                .orElseThrow(()->new ParkingSpotNotFoundException("cannot able to find any parking spot"));
    }
}
