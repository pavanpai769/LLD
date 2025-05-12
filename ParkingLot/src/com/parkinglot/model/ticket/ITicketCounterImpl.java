package com.parkinglot.model.ticket;

import com.parkinglot.model.vehicle.VehicleType;

public class ITicketCounterImpl implements ITicketCounter {
    @Override
    public Ticket generateTicket(String vehicleNumber, int entryGateNumber, String parkingSpotId, VehicleType vehicleType) {
        //you can write your custom logic to generate ticket here
        return new Ticket(vehicleNumber,entryGateNumber,parkingSpotId,vehicleType);
    }
}
