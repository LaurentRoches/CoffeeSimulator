import org.example.BankTransferPayment;
import org.example.PaymentStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTransferPaymentTest {
    @Test
    void testBankTransferPayment() {
        PaymentStrategy payment = new BankTransferPayment();
        String result = payment.pay(20.0);

        Assertions.assertEquals("Paiement de 20.0€ par virement bancaire.", result,
                "Le message de paiement doit être correctement formaté.");
    }
}
