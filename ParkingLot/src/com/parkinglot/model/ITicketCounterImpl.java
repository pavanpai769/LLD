package com.parkinglot.model;

public class ITicketCounterImpl implements ITicketCounter {
    int ticketCount =0;
    @Override
    public Ticket generateTicket(){
        //you can write your custom logic to generate ticket here
        ticketCount++;
        return new Ticket(String.valueOf(ticketCount));
    }
}
