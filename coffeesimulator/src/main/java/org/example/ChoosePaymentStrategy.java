package org.example;

public class ChoosePaymentStrategy{
    private PaymentStrategy paymentStrategy;

    public ChoosePaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public String executePayment(double amount) {
        return paymentStrategy.pay(amount);
    }
}
