import org.example.PaymentStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaymentStrategyTest {

    static class SimplePaymentStrategy implements PaymentStrategy {
        private String lastPayment = "";

        @Override
        public String pay(double amount) {
            lastPayment = "Paiement de " + amount + "€";
            return lastPayment;
        }

        public String getLastPayment() {
            return lastPayment;
        }
    }

    @Test
    void testPaymentStrategy() {
        SimplePaymentStrategy paymentStrategy = new SimplePaymentStrategy();
        String result = paymentStrategy.pay(10.0);

        Assertions.assertEquals("Paiement de 10.0€", result, "Le message de paiement doit être 'Paiement de 10.0€'");
        Assertions.assertEquals("Paiement de 10.0€", paymentStrategy.getLastPayment(), "Le dernier paiement enregistré doit être 'Paiement de 10.0€'");
    }
}
