package com.parkinglot.strategy;

import com.parkinglot.parkingspot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(List<? extends ParkingSpot> parkingSpots);
}
