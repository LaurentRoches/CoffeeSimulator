import static org.junit.jupiter.api.Assertions.*;

import org.example.Coffee;
import org.example.CoffeeView;
import org.example.Espresso;
import org.junit.jupiter.api.*;
import java.io.*;

public class CoffeeViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    private CoffeeView coffeeView;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        String simulatedInput = "1\n1\n1\n1\n1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        coffeeView = new CoffeeView();
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testDisplayWelcome() {
        coffeeView.displayWelcome();

        String expectedOutput = "Bienvenue dans le simulateur de café!\n1. Passer une commande\n2. Quitter\n";
        assertEquals(expectedOutput, outContent.toString(), "Les phrases ne correspondent pas");
    }

    @Test
    public void testGetMainChoice() {
        int choice = coffeeView.getMainChoice();

        assertEquals(1, choice, "L'utilisateur a choisi 'Passer une commande'");
    }

    @Test
    public void testSelectCoffee() {
        int choice = coffeeView.selectCoffee();

        assertEquals(1, choice, "L'utilisateur a choisi 'Espresso'");
    }

    @Test
    public void testSelectCondiments() {
        int choice = coffeeView.selectCondiments();

        assertEquals(1, choice, "L'utilisateur a choisi 'Chocolat'");
    }

    @Test
    public void testSelectPayment() {
        int choice = coffeeView.selectPayment();

        assertEquals(1, choice, "L'utilisateur a choisi 'Carte bancaire'");
    }

    @Test
    public void testDisplaySummary() {
        Coffee coffee = new Espresso();

        coffeeView.displaySummary(coffee);

        String expectedOutput = "Commande: Espresso\nTotal: 2.0€\nConfirmer? 1. Oui 2. Non\n";

        assertEquals(expectedOutput, outContent.toString(), "Les phrases ne correspondent pas");
    }

    @Test
    public void testConfirmOrder() {
        boolean confirmation = coffeeView.confirmOrder();

        assertTrue(confirmation, "L'utilisateur a confirmé la commande");
    }

    @Test
    public void testDisplayThankYou() {
        coffeeView.displayThankYou();

        String expectedOutput = "Merci pour votre commande!";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}
