package org.example;

public class PayPalPayment implements PaymentStrategy{
    @Override
    public String pay(double amount) {
        return "Paiement de " + amount + "€ via PayPal.";
    }
}
