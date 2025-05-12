package com.parkinglot.model.payment;

import com.parkinglot.model.ticket.Ticket;

import java.time.LocalTime;
import java.util.HashMap;

public class PaymentCalculatorImpl extends PaymentCalculator {

    @Override
    public double calculatePayment(Ticket ticket) throws IllegalArgumentException {
        if(!amountForVehiclePerHour.containsKey(ticket.getVehicleType())) {
            throw new IllegalArgumentException("Different TYpe vehicle found in ticket");
        }
        double amountPerHour = amountForVehiclePerHour.get(ticket.getVehicleType());

        LocalTime currentTime = LocalTime.now();

        double totalTime = (currentTime.getHour()+currentTime.getMinute()/60.0 + currentTime.getSecond()/3600.0)-(ticket.getTime().getHour()+ticket.getTime().getMinute()/60.0+ticket.getTime().getSecond()/3600.0);
        return amountPerHour*totalTime;
    }

    public PaymentCalculatorImpl() {
        super(new HashMap<>());
    }
}
