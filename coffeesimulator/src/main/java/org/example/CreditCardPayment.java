package org.example;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public String pay(double amount) {
        return "Paiement de " + amount + "€ par carte bancaire.";
    }
}

