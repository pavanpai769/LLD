package com.parkinglot.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    private String vehicleId;
    private String parkingSpotId;
    private LocalTime time;
    private LocalDate date;

    public Ticket(String vehicleId,String parkingSpotId) {
        this.vehicleId = vehicleId;
        this.parkingSpotId = parkingSpotId;
        this.time = LocalTime.now();
        this.date = LocalDate.now();
    }

    public String getTicketId() {
        return this.vehicleId;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public LocalDate getDate() {
        return this.date;
    }
}
