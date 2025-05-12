package com.parkinglot.builder;

import com.parkinglot.builder.model.ExitGate;
import com.parkinglot.model.payment.IPaymentProcessor;
import com.parkinglot.model.payment.PaymentCalculator;

public class ExitGateBuilder {
    private int exitGateNumber = -1;
    private PaymentCalculator paymentCalculator;
    private IPaymentProcessor paymentProcessor;

    public ExitGateBuilder setExitGateNumber(int exitGateNumber) {
        this.exitGateNumber = exitGateNumber;
        return this;
    }

    public ExitGateBuilder setPaymentCalculator(PaymentCalculator paymentCalculator) {
        this.paymentCalculator = paymentCalculator;
        return this;
    }

    public ExitGateBuilder setPaymentProcessor(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
        return this;
    }

    public ExitGate build()throws IllegalStateException{
        if(exitGateNumber == -1) {
            throw new IllegalStateException("Exit gate number not set");
        }else if(paymentCalculator == null) {
            throw new IllegalStateException("Payment Calculator not set");
        }else if(paymentProcessor == null) {
            throw new IllegalStateException("Payment Processor not set");
        }
        return new ExitGate(this);
    }

    public int getExitGateNumber() { return exitGateNumber; }

    public PaymentCalculator getPaymentCalculator() { return paymentCalculator; }

    public IPaymentProcessor getPaymentProcessor() { return paymentProcessor; }
}
