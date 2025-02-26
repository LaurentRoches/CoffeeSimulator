package org.example;

public class BankTransferPayment implements PaymentStrategy{
    @Override
    public String pay(double amount) {
        return "Paiement de " + amount + "€ par virement bancaire.";
    }
}
