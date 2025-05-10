package com.parkinglot.model;

import com.parkinglot.parkingspot.ParkingSpot;

public class ITicketCounterImpl implements ITicketCounter {
    @Override
    public Ticket generateTicket(String vehicleNumber,String parkingSpotId){
        //you can write your custom logic to generate ticket here
        return new Ticket(vehicleNumber,parkingSpotId);
    }
}
