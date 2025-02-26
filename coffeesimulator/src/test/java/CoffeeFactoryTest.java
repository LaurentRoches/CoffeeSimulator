import org.example.CafeAuLait;
import org.example.Coffee;
import org.example.CoffeeFactory;
import org.example.Espresso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeFactoryTest {
    @Test
    void testCreateEspresso() {
        Coffee coffee = CoffeeFactory.createCoffee("Espresso");
        Assertions.assertInstanceOf(Espresso.class, coffee, "Doit être une instance de Espresso");
        Assertions.assertEquals("Espresso", coffee.getDescription(), "'Espresso' est attendu");
        Assertions.assertEquals(2.0, coffee.getCost(), "'2.0' est attendu");
    }

    @Test
    void testCreateCafeAuLait() {
        Coffee coffee = CoffeeFactory.createCoffee("café au lait");
        Assertions.assertInstanceOf(CafeAuLait.class, coffee, "Doit être une instance de CafeAuLait");
        Assertions.assertEquals("Café au lait", coffee.getDescription(), "'Café au lait' est attendu");
        Assertions.assertEquals(2.5, coffee.getCost(), "'2.5' est attendu");
    }

    @Test
    void testCreateUnknownCoffee() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CoffeeFactory.createCoffee("unknown"), "Doit lever une exception pour un type inconnu");
    }
}
