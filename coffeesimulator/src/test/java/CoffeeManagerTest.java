import org.example.CoffeeManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.List;

class CoffeeManagerTest {

    @BeforeEach
    void resetSingleton() throws Exception {
        Field instance = CoffeeManager.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    void testSingletonInstance() {
        CoffeeManager firstInstance = CoffeeManager.getInstance();
        CoffeeManager secondInstance = CoffeeManager.getInstance();
        Assertions.assertSame(firstInstance, secondInstance, "CoffeeManager doit être un singleton");
    }

    @Test
    void testAddOrder() throws Exception {
        CoffeeManager manager = CoffeeManager.getInstance();
        manager.addOrder("Espresso");

        Field ordersField = CoffeeManager.class.getDeclaredField("orders");
        ordersField.setAccessible(true);
        List<String> orders = (List<String>) ordersField.get(manager);

        Assertions.assertEquals(1, orders.size(), "Il doit y avoir une seule commande");
        Assertions.assertEquals("Espresso", orders.getFirst(), "La commande doit être 'Espresso'");
    }
}
