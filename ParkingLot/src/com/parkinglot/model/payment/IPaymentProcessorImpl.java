package com.parkinglot.model.payment;

import com.parkinglot.strategy.payment.PaymentStrategy;

public class IPaymentProcessorImpl implements IPaymentProcessor {

    private PaymentStrategy paymentStrategy;

    public IPaymentProcessorImpl(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public void pay(double amount){
        paymentStrategy.pay(amount);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        if(paymentStrategy == null){
            throw new IllegalArgumentException("Payment strategy cannot be null");
        }
        this.paymentStrategy = paymentStrategy;
    }
}
