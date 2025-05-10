package com.parkinglot.model;


import com.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.parkinglot.factory.ParkingAreaManagerFactory;
import com.parkinglot.parkingmanager.ParkingAreaManager;
import com.parkinglot.parkingspot.ParkingSpot;

public class EntryGate {
   private final int entryGateNumber ;
   private ITicketCounter ticketCounter;
   private ParkingAreaManagerFactory parkingAreaManagerFactory;

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

    public void setParkingAreaManagerFactory(ParkingAreaManagerFactory parkingAreaManagerFactory) {
       this.parkingAreaManagerFactory = parkingAreaManagerFactory;
    }

    public Ticket parkVehicle(VehicleType vehicleType,Vehicle vehicle) throws NullPointerException, ParkingSpotNotFoundException {
        if(this.parkingAreaManagerFactory == null){
             throw new NullPointerException("please set the parking area manager factory");
        }

        ParkingSpot parkingSpot = this.parkingAreaManagerFactory.getParkingAreaManager(vehicleType).findParkingSpot();
        parkingSpot.park(vehicle);
        return this.ticketCounter.generateTicket(vehicle.getId(),parkingSpot.getId());
    }
}
