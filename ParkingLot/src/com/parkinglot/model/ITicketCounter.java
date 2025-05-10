package com.parkinglot.model;

import java.sql.Time;

public interface ITicketCounter {
    Ticket generateTicket(String vehicleId,String parkingSpotId);
}
