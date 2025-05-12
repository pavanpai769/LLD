package com.parkinglot.strategy.payment;

public class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying "+amount+" with upi");
    }
}
