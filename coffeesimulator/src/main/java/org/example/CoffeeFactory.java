package org.example;

public class CoffeeFactory {
    public static Coffee createCoffee(String type) {
        return switch(type.toLowerCase()) {
            case "espresso" -> new Espresso();
            case "café au lait" -> new CafeAuLait();
            default -> throw new IllegalArgumentException("Type de café inconnu");
        };
    }
}
