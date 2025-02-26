import org.example.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CoffeeTest {
    static class SimpleCoffee implements Coffee {
        public String getDescription() {
            return "Simple Coffee";
        }
        public double getCost() {
            return 2.0;
        }
    }

    @Test
    void testGetDescription() {
        Coffee coffee = new SimpleCoffee();
        Assertions.assertEquals("Simple Coffee", coffee.getDescription(), "La description doit être 'Simple Coffee'");
    }

    @Test
    void testGetCost() {
        Coffee coffee = new SimpleCoffee();
        Assertions.assertEquals(2.0, coffee.getCost(), "Le coût doit être 2.0");
    }
}
