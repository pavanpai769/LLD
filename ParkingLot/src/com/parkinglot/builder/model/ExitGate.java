package com.parkinglot.builder.model;

import com.parkinglot.builder.ExitGateBuilder;
import com.parkinglot.factory.ParkingAreaManagerFactory;
import com.parkinglot.model.payment.IPaymentProcessor;
import com.parkinglot.model.payment.PaymentCalculator;
import com.parkinglot.model.ticket.Ticket;
import com.parkinglot.model.vehicle.VehicleType;
import com.parkinglot.parkingmanager.ParkingAreaManager;
import com.parkinglot.parkingspot.ParkingSpot;

public class ExitGate {
    private final int exitGateNumber;
    private ParkingAreaManagerFactory parkingAreaManagerFactory;
    private PaymentCalculator paymentCalculator;
    private IPaymentProcessor paymentProcessor;

    public ExitGate(ExitGateBuilder exitGateBuilder) {
        this.exitGateNumber = exitGateBuilder.getExitGateNumber();
        this.paymentCalculator = exitGateBuilder.getPaymentCalculator();
        this.paymentProcessor = exitGateBuilder.getPaymentProcessor();
    }

    public void unparkVehicle(Ticket ticket) {
        double amount = paymentCalculator.calculatePayment(ticket);
        paymentProcessor.pay(amount);
        ParkingAreaManager<? extends ParkingSpot> parkingAreaManager = parkingAreaManagerFactory.getParkingAreaManager(ticket.getVehicleType());
        parkingAreaManager.getParkingSpotWithSpotId(ticket.getParkingSpotId()).unpark();
    }

    public void setParkingAreaManagerFactory(ParkingAreaManagerFactory parkingAreaManagerFactory) {
        this.parkingAreaManagerFactory = parkingAreaManagerFactory;
    }

    public void setIPaymentCalculator(PaymentCalculator paymentCalculator) {
        this.paymentCalculator = paymentCalculator;
    }


    public void setPaymentProcessor(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void setVehicleTypeAndAmount(VehicleType vehicleType, double amount) {
        this.paymentCalculator.setAmountForVehiclePerHour(vehicleType, amount);
    }

}
