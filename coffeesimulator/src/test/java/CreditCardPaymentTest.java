import org.example.CreditCardPayment;
import org.example.PaymentStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreditCardPaymentTest {

    @Test
    void testCreditCardPayment() {
        PaymentStrategy payment = new CreditCardPayment();
        String result = payment.pay(20.0);

        Assertions.assertEquals("Paiement de 20.0€ par carte bancaire.", result,
                "Le message de paiement doit être correctement formaté.");
    }
}