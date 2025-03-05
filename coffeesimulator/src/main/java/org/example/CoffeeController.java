package org.example;

public class CoffeeController {
    private final CoffeeView view;
    private final CoffeeManager manager;
    private final CoffeeNotifier notifier;

    public CoffeeController() {
        this.view = new CoffeeView();
        this.manager = CoffeeManager.getInstance();
        this.notifier = new CoffeeNotifier();
    }

    public void run() {
        view.displayWelcome();
        int mainChoice = view.getMainChoice();
        if (mainChoice == 2) return;

        Coffee coffee = selectCoffee();

        coffee = addCondiments(coffee);

        PaymentStrategy payment = selectPayment();

        view.displaySummary(coffee);
        if (view.confirmOrder()) {
            payment.pay(coffee.getCost());
            manager.addOrder(coffee.getDescription());
            notifier.notifyObservers("Votre commande est prête: " + coffee.getDescription());
        }
        view.displayThankYou();
    }

    private Coffee selectCoffee() {
        int choice = view.selectCoffee();
        return (choice == 1) ? new Espresso() : new CafeAuLait();
    }

    private Coffee addCondiments(Coffee coffee) {
        boolean adding = true;
        while (adding) {
            int choice = view.selectCondiments();
            switch (choice) {
                case 1:
                    coffee = new CoffeeWithChocolate(coffee);
                    break;
                case 2:
                    coffee = new CoffeeWithSugar(coffee);
                    break;
                default:
                    adding = false;
            }
        }
        return coffee;
    }

    private PaymentStrategy selectPayment() {
        int choice = view.selectPayment();
        if (choice == 1) {
            return new CreditCardPayment();
        } else if (choice == 2) {
            return new PayPalPayment();
        } else {
            return new BankTransferPayment();
        }
    }
}
