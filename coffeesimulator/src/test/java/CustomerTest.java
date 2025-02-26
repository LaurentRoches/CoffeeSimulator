import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CustomerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent, true));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testUpdatePrintsCorrectNotification() {

        String customerName = "Alice";
        Customer customer = new Customer(customerName);
        String message = "Nouvelle commande de café!";
        String expectedOutput = customerName + " a reçu la notification : " + message + System.lineSeparator();

        customer.update(message);

        System.out.flush();

        assertEquals(expectedOutput, outContent.toString());
    }
}
