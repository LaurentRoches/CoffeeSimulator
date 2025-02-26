package org.example;

import java.util.ArrayList;
import java.util.List;

public class CoffeeManager {
    private static CoffeeManager instance;
    private List<String> orders = new ArrayList<>();

    private CoffeeManager() {}

    public static CoffeeManager getInstance() {
        if (instance == null) {
            instance = new CoffeeManager();
        }
        return instance;
    }

    public void addOrder(String order) {
        orders.add(order);
        System.out.println("Commande ajoutée: " + order);
    }
}
