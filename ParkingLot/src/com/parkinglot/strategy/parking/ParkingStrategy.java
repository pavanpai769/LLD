package com.parkinglot.strategy.parking;

import com.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.parkinglot.parkingspot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(List<? extends ParkingSpot> parkingSpots)throws ParkingSpotNotFoundException;
}
