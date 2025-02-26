package org.example;

public class CoffeeWithSugar extends CoffeeDecorator{
    public CoffeeWithSugar(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", sucre";
    }
    public double getCost() {
        return coffee.getCost() + 0.2;
    }
}
