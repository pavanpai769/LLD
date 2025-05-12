package com.parkinglot.builder.model;

import com.parkinglot.builder.ParkingLotBuilder;
import com.parkinglot.factory.ParkingAreaManagerFactory;
import com.parkinglot.model.vehicle.VehicleType;
import com.parkinglot.parkingmanager.ParkingAreaManager;
import com.parkinglot.parkingspot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private ParkingAreaManagerFactory parkingAreaManagerFactory;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;

    public ParkingLot(ParkingLotBuilder parkingLotBuilder) {
        this.parkingAreaManagerFactory = parkingLotBuilder.getParkingAreaManagerFactory();
        this.entryGates = parkingLotBuilder.getEntryGates();
        this.exitGates = parkingLotBuilder.getExitGates();
    }

    public ParkingAreaManagerFactory getParkingAreaManagerFactory() {
        return parkingAreaManagerFactory;
    }

    public void setParkingAreaManagerFactory(ParkingAreaManagerFactory parkingAreaManagerFactory) throws IllegalStateException{
        if(parkingAreaManagerFactory == null){
            throw new IllegalStateException("ParkingAreaManagerFactory is already set");
        }
        this.parkingAreaManagerFactory = parkingAreaManagerFactory;
    }

    public void addParkingAreaManager(VehicleType vehicleType, ParkingAreaManager<? extends ParkingSpot> parkingAreaManager) throws IllegalStateException{
        this.parkingAreaManagerFactory.addParkingAreaManager(vehicleType, parkingAreaManager);
    }


    public void addEntryGate(EntryGate entryGate) throws IllegalArgumentException{
        if(entryGate == null){
            throw new IllegalArgumentException("EntryGate is null");
        }
        entryGate.setParkingAreaManagerFactory(this.parkingAreaManagerFactory);
        this.entryGates.add(entryGate);
    }

    public void addEntryGates(List<EntryGate> entryGates) throws IllegalArgumentException{
        for(EntryGate entryGate : entryGates){
            if(entryGate == null){
                throw new IllegalArgumentException("EntryGate is null");
            }
            entryGate.setParkingAreaManagerFactory(this.parkingAreaManagerFactory);
            this.entryGates.add(entryGate);
        }
    }

    public void addExitGate(ExitGate exitGate) throws IllegalArgumentException{
        if(exitGate == null){
            throw new IllegalArgumentException("ExitGate is null");
        }
        exitGate.setParkingAreaManagerFactory(this.parkingAreaManagerFactory);
        if(this.exitGates == null){
            this.exitGates = new ArrayList<>();
        }
        this.exitGates.add(exitGate);
    }

    public void addExitGates(List<ExitGate> exitGates) throws IllegalArgumentException{
        for(ExitGate exitGate : exitGates){
            if(exitGate == null){
                throw new IllegalArgumentException("ExitGate is null");
            }
            if(this.exitGates == null){
                this.exitGates = new ArrayList<>();
            }
            this.exitGates.add(exitGate);
        }
    }

}
