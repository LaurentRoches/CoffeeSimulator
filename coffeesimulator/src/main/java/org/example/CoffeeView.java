package org.example;

import java.util.Scanner;

public class CoffeeView {
    private final Scanner scanner;

    public CoffeeView() {
        scanner = new Scanner(System.in);
    }

    public void displayWelcome() {
        System.out.println("Bienvenue dans le simulateur de café!");
        System.out.println("1. Passer une commande\n2. Quitter");
    }

    public int getMainChoice() {
        return scanner.nextInt();
    }

    public int selectCoffee() {
        System.out.println("Choisissez un café:\n1. Espresso\n2. Café au lait");
        return scanner.nextInt();
    }

    public int selectCondiments() {
        System.out.println("Ajouter des condiments?\n1. Chocolat (+0.5€)\n2. Sucre (+0.2€)\n3. Aucun");
        return scanner.nextInt();
    }

    public int selectPayment() {
        System.out.println("Choisissez votre moyen de paiement:\n1. Carte bancaire\n2. PayPal\n3. Virement bancaire");
        return scanner.nextInt();
    }

    public void displaySummary(Coffee coffee) {
        System.out.println("Commande: " + coffee.getDescription());
        System.out.println("Total: " + coffee.getCost() + "€");
        System.out.println("Confirmer? 1. Oui 2. Non");
    }

    public boolean confirmOrder() {
        int choice = scanner.nextInt();
        return choice == 1;
    }

    public void displayThankYou() {
        System.out.println("Merci pour votre commande!");
    }
}

