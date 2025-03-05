package org.example;

import java.util.Scanner;

public class CoffeeView {
    private final Scanner scanner;

    public CoffeeView() {
        scanner = new Scanner(System.in);
    }

    public void displayWelcome() {
        System.out.print("Bienvenue dans le simulateur de café!\n");
        System.out.print("1. Passer une commande\n2. Quitter\n");
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
        System.out.print("Commande: " + coffee.getDescription() + "\n");
        System.out.print("Total: " + coffee.getCost() + "€\n");
        System.out.print("Confirmer? 1. Oui 2. Non\n");
    }


    public boolean confirmOrder() {
        int choice = scanner.nextInt();
        return choice == 1;
    }

    public void displayThankYou() {
        System.out.println("Merci pour votre commande!");
    }
}

