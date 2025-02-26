import org.example.PayPalPayment;
import org.example.PaymentStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PayPalPaymentTest {
    @Test
    void testPayPalPayment() {
        PaymentStrategy payment = new PayPalPayment();
        String result = payment.pay(20.0);

        Assertions.assertEquals("Paiement de 20.0€ via PayPal.", result,
                "Le message de paiement doit être correctement formaté.");
    }
}
