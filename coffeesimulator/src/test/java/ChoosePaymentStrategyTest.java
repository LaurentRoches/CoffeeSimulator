import org.example.ChoosePaymentStrategy;
import org.example.PaymentStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ChoosePaymentStrategyTest {
    static class DummyPaymentStrategy implements PaymentStrategy {
        @Override
        public String pay(double amount) {
            return "Paiement de " + amount + "€ avec DummyPaymentStrategy";
        }
    }

    static class AutreDummyPaymentStrategy implements PaymentStrategy {
        @Override
        public String pay(double amount) {
            return "Paiement de " + amount + "€ avec AutreDummyPaymentStrategy";
        }
    }

    @Test
    public void testExecutePayment() {
        PaymentStrategy dummy = new DummyPaymentStrategy();
        ChoosePaymentStrategy choosePaymentStrategy = new ChoosePaymentStrategy(dummy);

        double amount = 100.0;
        String result = choosePaymentStrategy.executePayment(amount);
        assertEquals("Paiement de 100.0€ avec DummyPaymentStrategy", result);

        PaymentStrategy autreDummy = new AutreDummyPaymentStrategy();
        choosePaymentStrategy.setPaymentStrategy(autreDummy);
        amount = 50.0;
        result = choosePaymentStrategy.executePayment(amount);
        assertEquals("Paiement de 50.0€ avec AutreDummyPaymentStrategy", result);
    }
}
