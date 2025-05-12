package com.parkinglot.builder.model;


import com.parkinglot.builder.EntryGateBuilder;
import com.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.parkinglot.factory.ParkingAreaManagerFactory;
import com.parkinglot.model.ticket.ITicketCounter;
import com.parkinglot.model.ticket.Ticket;
import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.model.vehicle.VehicleType;
import com.parkinglot.parkingspot.ParkingSpot;

public class EntryGate {
   private final int entryGateNumber ;
   private ITicketCounter ticketCounter;
   private ParkingAreaManagerFactory parkingAreaManagerFactory;

   public EntryGate(int entryGateNumber,ITicketCounter ticketCounter) {
       this.entryGateNumber = entryGateNumber;
       this.ticketCounter = ticketCounter;
   }

   public EntryGate(EntryGateBuilder entryGateBuilder) {
       this.entryGateNumber = entryGateBuilder.getEntryGateNumber();
       this.ticketCounter = entryGateBuilder.getTicketCounter();
   }



    public int getEntryGateNumber() {
        return entryGateNumber;
    }

    public ITicketCounter getTicketCounter() {
        return ticketCounter;
    }

    public Ticket parkVehicle(Vehicle vehicle) throws NullPointerException, ParkingSpotNotFoundException {
        if(this.parkingAreaManagerFactory == null){
             throw new NullPointerException("please set the parking area manager factory");
        }
        VehicleType vehicleType = vehicle.getVehicleType();
        ParkingSpot parkingSpot = this.parkingAreaManagerFactory.getParkingAreaManager(vehicleType).findParkingSpot();
        parkingSpot.park(vehicle);
        return this.ticketCounter.generateTicket(vehicle.getId(),this.entryGateNumber,parkingSpot.getId(),vehicle.getVehicleType());
    }

    public void setParkingAreaManagerFactory(ParkingAreaManagerFactory parkingAreaManagerFactory) {
        this.parkingAreaManagerFactory = parkingAreaManagerFactory;
    }

    public void setTicketCounter(ITicketCounter ticketCounter) {
       this.ticketCounter = ticketCounter;
    }
}
