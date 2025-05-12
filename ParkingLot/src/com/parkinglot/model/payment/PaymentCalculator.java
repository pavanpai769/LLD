package com.parkinglot.model.payment;

import com.parkinglot.model.ticket.Ticket;
import com.parkinglot.model.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public abstract class PaymentCalculator {
    Map<VehicleType,Double> amountForVehiclePerHour;

    public abstract double calculatePayment(Ticket ticket);

    public void setAmountForVehiclePerHour(VehicleType vehicleType, double amountPerHour) {
        if(amountForVehiclePerHour == null) {
            amountForVehiclePerHour = new HashMap<>();
        }
        amountForVehiclePerHour.put(vehicleType, amountPerHour);
    }

    public PaymentCalculator(Map<VehicleType,Double> amountForVehiclePerHour) {
        this.amountForVehiclePerHour = amountForVehiclePerHour;
    }
}
