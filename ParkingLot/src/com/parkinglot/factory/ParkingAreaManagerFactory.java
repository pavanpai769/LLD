package com.parkinglot.factory;

import com.parkinglot.model.VehicleType;
import com.parkinglot.parkingmanager.ParkingAreaManager;

import java.util.HashMap;
import java.util.Map;

public class ParkingAreaManagerFactory {
    private Map<VehicleType, ParkingAreaManager> parkingAreaManagers;

    public ParkingAreaManagerFactory() {
        parkingAreaManagers = new HashMap<>();
    }

    public ParkingAreaManager<?> getParkingAreaManager(VehicleType vehicleType) throws IllegalArgumentException{
        if(parkingAreaManagers.containsKey(vehicleType)) {
            return parkingAreaManagers.get(vehicleType);
        }
        throw new IllegalArgumentException("No parkingAreaManager found for vehicle type "+vehicleType);
    }

    public void addParkingAreaManager(VehicleType vehicleType, ParkingAreaManager<?> parkingAreaManager)throws IllegalStateException ,NullPointerException{
        if(parkingAreaManager == null) {
            throw new NullPointerException("ParkingAreaManager cannot be null");
        }
        if(vehicleType == null) {
            throw new NullPointerException("VehicleType cannot be null");
        }
        if(parkingAreaManager.getVehicleType() != vehicleType) {
            throw new IllegalArgumentException("ParkingAreaManager does not match vehicleType "+vehicleType);
        }
        if(parkingAreaManagers.containsKey(vehicleType)) {
            throw new IllegalStateException("ParkingAreaManager already exists for vehicle type "+vehicleType);
        }
        parkingAreaManagers.put(vehicleType, parkingAreaManager);
    }


}
