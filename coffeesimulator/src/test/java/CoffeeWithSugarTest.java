import org.example.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoffeeWithSugarTest {

    static class SimpleCoffee implements Coffee {
        public String getDescription() {
            return "Simple Coffee";
        }
        public double getCost() {
            return 2.0;
        }
    }

    @Test
    void testCoffeeWithSugar() {
        Coffee coffee = new org.example.CoffeeWithSugar(new SimpleCoffee());
        Assertions.assertEquals("Simple Coffee, sucre", coffee.getDescription(), "La description doit inclure 'sucre'");
        Assertions.assertEquals(2.2, coffee.getCost(), "Le coût doit être 2.2 après ajout du sucre");
    }
}
