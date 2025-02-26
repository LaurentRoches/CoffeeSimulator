import org.example.Coffee;
import org.example.CoffeeWithChocolate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoffeeWithChocolateTest {

    static class SimpleCoffee implements Coffee {
        public String getDescription() {
            return "Simple Coffee";
        }
        public double getCost() {
            return 2.0;
        }
    }

    @Test
    void testCoffeeWithChocolate() {
        Coffee coffee = new CoffeeWithChocolate(new SimpleCoffee());
        Assertions.assertEquals("Simple Coffee, chocolat", coffee.getDescription(), "La description doit inclure 'chocolat'");
        Assertions.assertEquals(2.5, coffee.getCost(), "Le coût doit être 2.5 après ajout du chocolat");
    }
}
