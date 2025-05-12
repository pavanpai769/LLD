package com.parkinglot.strategy.payment;

public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying "+amount+" credit card");
    }
}
