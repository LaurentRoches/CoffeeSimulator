package org.example;

public class CafeAuLait implements Coffee{
    @Override
    public String getDescription() {
        return "Café au lait";
    }

    @Override
    public double getCost() {
        return 2.5;
    }
}
