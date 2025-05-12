package com.parkinglot.builder;

import com.parkinglot.builder.model.EntryGate;
import com.parkinglot.builder.model.ExitGate;
import com.parkinglot.builder.model.ParkingLot;
import com.parkinglot.factory.ParkingAreaManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotBuilder {
    private ParkingAreaManagerFactory parkingAreaManagerFactory;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;


    public ParkingLotBuilder setParkingAreaManagerFactory(ParkingAreaManagerFactory parkingAreaManagerFactory) {
        this.parkingAreaManagerFactory = parkingAreaManagerFactory;
        return this;
    }

    public ParkingLotBuilder setEntryGates(List<EntryGate> entryGates) throws IllegalStateException, IllegalArgumentException {
        if(entryGates == null || entryGates.size() == 0) {
            throw new IllegalArgumentException("Entry gates cannot be null or empty. Parking lot must have at least one entry gate.");
        }else if(parkingAreaManagerFactory == null) {
            throw new IllegalStateException("please set the parking area Manager factory first.");
        }
        if(this.entryGates == null) {
            this.entryGates = new ArrayList<>();
        }

        for(EntryGate entryGate : entryGates) {
            this.setEntryGate(entryGate);
        }

        return this;
    }

    public ParkingLotBuilder setExitGates(List<ExitGate> exitGates) throws IllegalStateException, IllegalArgumentException {
        if(exitGates == null || exitGates.isEmpty()) {
            throw new IllegalStateException("Exit gate cannot be null or empty. Parking lot must have at least one exit gate.");
        }else if(parkingAreaManagerFactory == null) {
            throw new IllegalStateException("please set the parking area Manager factory first.");
        }

        for (ExitGate exitGate : exitGates) {
            this.setExitGate(exitGate);
        }
        return this;
    }

    public ParkingLotBuilder setEntryGate(EntryGate entryGate) throws IllegalStateException, IllegalArgumentException {
        if(entryGate == null) {
            throw new IllegalArgumentException("Entry gate cannot be null.");
        }else if(parkingAreaManagerFactory == null) {
            throw new IllegalStateException("please set the parking area Manager factory first.");
        }
        entryGate.setParkingAreaManagerFactory(parkingAreaManagerFactory);
        if(entryGates == null) {
            this.entryGates = new ArrayList<>();
        }
        this.entryGates.add(entryGate);
        return this;
    }

    public ParkingLotBuilder setExitGate(ExitGate exitGate) throws IllegalStateException, IllegalArgumentException {
        if(exitGate == null) {
            throw new IllegalArgumentException("Exit gate cannot be null.");
        } else if(parkingAreaManagerFactory == null) {
            throw new IllegalStateException("please set the parking area Manager factory first.");
        }
        if(this.exitGates == null) {
            this.exitGates = new ArrayList<>();
        }

        exitGate.setParkingAreaManagerFactory(parkingAreaManagerFactory);
        this.exitGates.add(exitGate);

        return this;
    }

    public ParkingLot build() {
        if(parkingAreaManagerFactory == null) {
            throw new IllegalStateException("please set the parking area Manager factory first.");
        } else if(entryGates == null) {
            throw new IllegalStateException("please set the entry gate. parking must have at least one entry gate.");
        }else if(exitGates == null) {
            throw new IllegalStateException("please set exit gate.parking lot must have at least one exit gate.");
        }
        return  new ParkingLot(this);
    }


    public ParkingAreaManagerFactory getParkingAreaManagerFactory() {
        return parkingAreaManagerFactory;
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public List<ExitGate> getExitGates() {
        return exitGates;
    }
}
