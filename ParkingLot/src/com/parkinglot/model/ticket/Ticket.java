package com.parkinglot.model.ticket;

import com.parkinglot.model.vehicle.VehicleType;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {

    private String vehicleId;
    private int entryGateNumber;
    private String parkingSpotId;
    private VehicleType vehicleType;
    private LocalTime time;
    private LocalDate date;

    public Ticket(String vehicleId,int entryGateNumber,String parkingSpotId,VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.entryGateNumber = entryGateNumber;
        this.parkingSpotId = parkingSpotId;
        this.vehicleType = vehicleType;
        this.time = LocalTime.now();
        this.date = LocalDate.now();
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public int getEntryGateNumber() { return this.entryGateNumber; }

    public String getParkingSpotId() { return this.parkingSpotId;}

    public VehicleType getVehicleType() { return this.vehicleType;}

    public LocalTime getTime() {
        return this.time;
    }

    public LocalDate getDate() {
        return this.date;
    }
}
