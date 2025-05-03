package com.parkinglot.model;

import com.parkinglot.factory.ParkingAreaManagerFactory;
import com.parkinglot.parkingmanager.ParkingAreaManager;

import java.util.List;

public class ParkingLot {
    private ParkingAreaManagerFactory parkingAreaManagerFactory;
    protected List<EntryGate> entryGates;

    public ParkingAreaManagerFactory getParkingAreaManagerFactory() {
        return parkingAreaManagerFactory;
    }

    public void setParkingAreaManagerFactory(ParkingAreaManagerFactory parkingAreaManagerFactory) throws IllegalStateException{
        if(parkingAreaManagerFactory != null){
            throw new IllegalStateException("ParkingAreaManagerFactory is already set");
        }
        this.parkingAreaManagerFactory = parkingAreaManagerFactory;
    }

    public void addParkingAreaManager(VehicleType vehicleType,ParkingAreaManager parkingAreaManager) throws IllegalStateException{
        this.parkingAreaManagerFactory.addParkingAreaManager(vehicleType, parkingAreaManager);
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(List<EntryGate> entryGates) throws IllegalArgumentException{
        for(EntryGate entryGate : entryGates){
            if(entryGate == null){
                throw new IllegalArgumentException("EntryGate is null");
            }
            this.entryGates.add(entryGate);
        }
    }

    public void addEntryGate(EntryGate entryGate) throws IllegalArgumentException{
        if(entryGate == null){
            throw new IllegalArgumentException("EntryGate is null");
        }
        this.entryGates.add(entryGate);
    }


}
