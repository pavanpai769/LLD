package com.parkinglot;

import com.parkinglot.factory.ParkingAreaManagerFactory;
import com.parkinglot.model.*;
import com.parkinglot.parkingmanager.FourWheelerParkingAreaManager;
import com.parkinglot.parkingmanager.ParkingAreaManager;
import com.parkinglot.parkingmanager.TwoWheelerParkingAreaManager;
import com.parkinglot.parkingspot.FourWheelerParkingSpot;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.parkingspot.TwoWheelerParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       List<TwoWheelerParkingSpot> twoWheelerParkingSpots = new ArrayList<>();
       for(int i=1;i <10;i++){
           TwoWheelerParkingSpot parkingSpot = new TwoWheelerParkingSpot("T"+i,500);
           twoWheelerParkingSpots.add(parkingSpot);
       }

       ParkingAreaManager<TwoWheelerParkingSpot> twoWheelerParkingManager = new TwoWheelerParkingAreaManager(twoWheelerParkingSpots);

       TwoWheelerParkingSpot newTwoWheelerParkingSpot = new TwoWheelerParkingSpot("T10",500);
       twoWheelerParkingManager.addParkingSpot(newTwoWheelerParkingSpot);


       List<FourWheelerParkingSpot> fourWheelerParkingSpots = new ArrayList<>();
       for(int i=1;i <10;i++){
           FourWheelerParkingSpot parkingSpot = new FourWheelerParkingSpot("F"+i,5000);
           fourWheelerParkingSpots.add(parkingSpot);
       }

       ParkingAreaManager<FourWheelerParkingSpot> fourWheelerParkingAreaManager = new FourWheelerParkingAreaManager(fourWheelerParkingSpots);

       FourWheelerParkingSpot newFourWheelerParkingSpot = new FourWheelerParkingSpot("F10",5000);
       fourWheelerParkingAreaManager.addParkingSpot(newFourWheelerParkingSpot);

        ParkingAreaManagerFactory parkingAreaManagerFactory = new ParkingAreaManagerFactory();
        parkingAreaManagerFactory.addParkingAreaManager(VehicleType.TwoWheeler,twoWheelerParkingManager);


        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingAreaManagerFactory(parkingAreaManagerFactory);
        parkingLot.addParkingAreaManager(VehicleType.FourWheeler,fourWheelerParkingAreaManager);

        EntryGate entry1 = new EntryGate(1);

        ITicketCounter ticketCounter1 = new ITicketCounterImpl();
        entry1.setTicketCounter(ticketCounter1);

        EntryGate entry2 = new EntryGate(2);

        ITicketCounter ticketCounter2 = new ITicketCounterImpl();
        entry2.setTicketCounter(ticketCounter2);

        parkingLot.addEntryGate(entry1);
        parkingLot.addEntryGate(entry2);


    }
}
