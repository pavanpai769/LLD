package com.parkinglot;

import com.parkinglot.builder.EntryGateBuilder;
import com.parkinglot.builder.ExitGateBuilder;
import com.parkinglot.builder.ParkingLotBuilder;
import com.parkinglot.builder.model.EntryGate;
import com.parkinglot.builder.model.ExitGate;
import com.parkinglot.builder.model.ParkingLot;
import com.parkinglot.factory.ParkingAreaManagerFactory;
import com.parkinglot.factory.ParkingSpotFactory;
import com.parkinglot.model.payment.IPaymentProcessorImpl;
import com.parkinglot.model.payment.PaymentCalculator;
import com.parkinglot.model.payment.PaymentCalculatorImpl;
import com.parkinglot.model.ticket.ITicketCounterImpl;
import com.parkinglot.model.ticket.Ticket;
import com.parkinglot.model.vehicle.FourWheeler;
import com.parkinglot.model.vehicle.TwoWheeler;
import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.model.vehicle.VehicleType;
import com.parkinglot.parkingmanager.FourWheelerParkingAreaManager;
import com.parkinglot.parkingmanager.ParkingAreaManager;
import com.parkinglot.parkingmanager.TwoWheelerParkingAreaManager;
import com.parkinglot.parkingspot.FourWheelerParkingSpot;
import com.parkinglot.parkingspot.TwoWheelerParkingSpot;
import com.parkinglot.strategy.payment.CreditCardPaymentStrategy;
import com.parkinglot.strategy.parking.ParkAnyWhere;
import com.parkinglot.strategy.payment.UPIPaymentStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // create a list of two-wheeler parking spot id
        List<String> twoWheelerParkingSpotsId = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            twoWheelerParkingSpotsId.add("T" + i);
        }


        // use two-wheeler spot id list and get list of two-wheeler parking spots
        List<TwoWheelerParkingSpot> twoWheelerParkingSpots = ParkingSpotFactory
                .getParkingSpot(VehicleType.TwoWheeler, twoWheelerParkingSpotsId)
                .stream()
                .map(parkingSpot -> (TwoWheelerParkingSpot) parkingSpot)
                .collect(Collectors.toList());


        // create a parking area manager for two-wheeler parking spots and add parking strategy
        ParkingAreaManager<TwoWheelerParkingSpot> twoWheelerParkingManager = new TwoWheelerParkingAreaManager(twoWheelerParkingSpots);
        twoWheelerParkingManager.setParkingStrategy(new ParkAnyWhere());

        // create one more two-wheeler parking spot and add it to two-wheeler parking area manager
        TwoWheelerParkingSpot newTwoWheelerParkingSpot = (TwoWheelerParkingSpot) ParkingSpotFactory.getParkingSpot(VehicleType.TwoWheeler, "T10");
        twoWheelerParkingManager.addParkingSpot(newTwoWheelerParkingSpot);


        // create a list of four-wheeler parking spot id
        List<String> fourWheelerParkingSpotsId = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            fourWheelerParkingSpotsId.add("F" + i);
        }


        // use four-wheeler spot id list and get list of four-wheeler parking spots
        List<FourWheelerParkingSpot> fourWheelerParkingSpots = ParkingSpotFactory
                .getParkingSpot(VehicleType.FourWheeler, fourWheelerParkingSpotsId)
                .stream()
                .map(parkingSpot -> (FourWheelerParkingSpot) parkingSpot)
                .collect(Collectors.toList());


        // create a parking area manager for four-wheeler parking spots and set parking strategy
        ParkingAreaManager<FourWheelerParkingSpot> fourWheelerParkingAreaManager = new FourWheelerParkingAreaManager(fourWheelerParkingSpots);
        fourWheelerParkingAreaManager.setParkingStrategy(new ParkAnyWhere());

        // create one more four-wheeler parking spot and add it to four-wheeler parking area manager
        FourWheelerParkingSpot newFourWheelerParkingSpot = (FourWheelerParkingSpot) ParkingSpotFactory.getParkingSpot(VehicleType.FourWheeler, "F10");
        fourWheelerParkingAreaManager.addParkingSpot(newFourWheelerParkingSpot);


        // create a parking area manager factory to handle all parking area manager
        ParkingAreaManagerFactory parkingAreaManagerFactory = new ParkingAreaManagerFactory();


        // add parking area managers to the factory
        parkingAreaManagerFactory.addParkingAreaManager(VehicleType.TwoWheeler, twoWheelerParkingManager);
        parkingAreaManagerFactory.addParkingAreaManager(VehicleType.FourWheeler, fourWheelerParkingAreaManager);


        // create entry gates
        EntryGate entry1 = new EntryGateBuilder()
                .setEntryGateNumber(1)
                .setTicketCounter(new ITicketCounterImpl())
                .build();

        EntryGate entry2 = new EntryGateBuilder()
                .setEntryGateNumber(2)
                .setTicketCounter(new ITicketCounterImpl())
                .build();

        PaymentCalculator paymentCalculator = new PaymentCalculatorImpl();
        paymentCalculator.setAmountForVehiclePerHour(VehicleType.TwoWheeler, 50.02);
        paymentCalculator.setAmountForVehiclePerHour(VehicleType.FourWheeler, 200.90);

        // create exit gate
        ExitGate exit1 = new ExitGateBuilder()
                .setExitGateNumber(1)
                .setPaymentCalculator(paymentCalculator)
                .setPaymentProcessor(new IPaymentProcessorImpl(new UPIPaymentStrategy()))
                .build();

        ExitGate exit2 = new ExitGateBuilder()
                .setExitGateNumber(2)
                .setPaymentCalculator(paymentCalculator)
                .setPaymentProcessor(new IPaymentProcessorImpl(new CreditCardPaymentStrategy()))
                .build();


        // create parking lot
        ParkingLot parkingLot = new ParkingLotBuilder()
                .setParkingAreaManagerFactory(parkingAreaManagerFactory)
                .setEntryGates(Arrays.asList(entry1, entry2))
                .setExitGates(Arrays.asList(exit1, exit2))
                .build();

        // create two vehicles
        Vehicle car = new FourWheeler("KA47N2909");
        Vehicle bike = new TwoWheeler("KA27E5678");


        // park vehicles and get ticket
        Ticket ticketForCar = entry1.parkVehicle(car);
        Ticket ticketForBike = entry2.parkVehicle(bike);

        //park 10 seconds
        Thread.sleep(10000);

        //unpark both
        exit1.unparkVehicle(ticketForCar);
        exit2.unparkVehicle(ticketForBike);

    }
}
