import org.example.Espresso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EspressoTest {
    @Test
    void testGetDescription() {
        Espresso Espresso = new Espresso();
        Assertions.assertEquals("Espresso", Espresso.getDescription(), "'Espresso' est attendu");
    }
    @Test
    void testGetCost() {
        Espresso Espresso = new Espresso();
        Assertions.assertEquals(2.0, Espresso.getCost(), "Le prix attendu est '2.0'");
    }
}
