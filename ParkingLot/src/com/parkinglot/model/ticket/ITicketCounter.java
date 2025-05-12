package com.parkinglot.model.ticket;

import com.parkinglot.model.vehicle.VehicleType;

public interface ITicketCounter {
    Ticket generateTicket(String vehicleId, int entryGateNumber, String parkingSpotId, VehicleType vehicleType);
}
