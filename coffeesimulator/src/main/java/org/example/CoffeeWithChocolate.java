package org.example;

public class CoffeeWithChocolate extends CoffeeDecorator{
    public CoffeeWithChocolate(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + ", chocolat";
    }
    public double getCost() {
        return coffee.getCost() + 0.5;
    }
}
