package com.parkinglot.model;

import com.parkinglot.factory.ParkingAreaManagerFactory;
import com.parkinglot.parkingmanager.ParkingAreaManager;

public class EntryGate {
   private int entryGateNumber ;
   private ITicketCounter ticketCounter;

   public EntryGate(int entryGateNumber,ITicketCounter ticketCounter) {
       this.entryGateNumber = entryGateNumber;
       this.ticketCounter = ticketCounter;
   }

   public EntryGate(int entryGateNumber) {
       this.entryGateNumber = entryGateNumber;
   }


    public int getEntryGateNumber() {
        return entryGateNumber;
    }

    public ITicketCounter getTicketCounter() {
        return ticketCounter;
    }

    public void setTicketCounter(ITicketCounter ticketCounter) {
        this.ticketCounter = ticketCounter;
    }


}
