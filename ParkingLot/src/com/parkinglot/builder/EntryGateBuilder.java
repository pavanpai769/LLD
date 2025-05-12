package com.parkinglot.builder;

import com.parkinglot.builder.model.EntryGate;
import com.parkinglot.model.ticket.ITicketCounter;

public class EntryGateBuilder {
    private int entryGateNumber = -1;
    private ITicketCounter ticketCounter;

    public EntryGateBuilder setEntryGateNumber(int entryGateNumber) {
        this.entryGateNumber = entryGateNumber;
        return this;
    }

    public EntryGateBuilder setTicketCounter(ITicketCounter ticketCounter) {
        this.ticketCounter = ticketCounter;
        return this;
    }

    public EntryGate build()throws IllegalStateException{
        if(entryGateNumber == -1) {
            throw new IllegalStateException("Entry gate number not set");
        }else if(ticketCounter == null) {
            throw new IllegalStateException("Ticket counter not set");
        }
        return new EntryGate(this);
    }

    public int getEntryGateNumber() {
        return entryGateNumber;
    }

    public ITicketCounter getTicketCounter() {
        return ticketCounter;
    }

}
