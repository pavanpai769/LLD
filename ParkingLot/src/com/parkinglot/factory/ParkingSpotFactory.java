package com.parkinglot.factory;

import com.parkinglot.model.vehicle.VehicleType;
import com.parkinglot.parkingspot.FourWheelerParkingSpot;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.parkingspot.TwoWheelerParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotFactory {

    private ParkingSpotFactory() {}

    public static ParkingSpot getParkingSpot(VehicleType vehicleType,String spotId) throws IllegalArgumentException {
        if(vehicleType.equals(VehicleType.TwoWheeler)) {
            return new TwoWheelerParkingSpot(spotId);

        } else if (vehicleType.equals(VehicleType.FourWheeler)) {
            return new FourWheelerParkingSpot(spotId);
        }else{
            throw new IllegalArgumentException("vehicle type is not supported");
        }
    }

    public static List<?> getParkingSpot(VehicleType vehicleType,List<String> spotIdList) throws IllegalArgumentException {
        List<ParkingSpot> spotList = new ArrayList<>();
        if(vehicleType.equals(VehicleType.TwoWheeler)) {

            for(String spotId : spotIdList) {
                spotList.add(new TwoWheelerParkingSpot(spotId));
            }
        }else if (vehicleType.equals(VehicleType.FourWheeler)) {
            for(String spotId : spotIdList) {
                spotList.add(new FourWheelerParkingSpot(spotId));
            }
        }else{
            throw new IllegalArgumentException("vehicle type is not supported");
        }
        return spotList;
    }

}
