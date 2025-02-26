import org.example.Coffee;
import org.example.CoffeeDecorator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoffeeDecoratorTest {

    static class SimpleCoffee implements Coffee {
        public String getDescription() {
            return "Simple Coffee";
        }
        public double getCost() {
            return 2.0;
        }
    }

    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }
        @Override
        public String getDescription() {
            return super.getDescription() + ", Milk";
        }
        @Override
        public double getCost() {
            return super.getCost() + 0.5;
        }
    }

    @Test
    void testDecoratorKeepsBaseBehavior() {
        Coffee coffee = new SimpleCoffee();
        Assertions.assertEquals("Simple Coffee", coffee.getDescription(), "La description doit être 'Simple Coffee'");
        Assertions.assertEquals(2.0, coffee.getCost(), "Le coût doit être 2.0");
    }

    @Test
    void testMilkDecorator() {
        Coffee coffee = new MilkDecorator(new SimpleCoffee());
        Assertions.assertEquals("Simple Coffee, Milk", coffee.getDescription(), "La description doit inclure 'Milk'");
        Assertions.assertEquals(2.5, coffee.getCost(), "Le coût doit être 2.5 après ajout du lait");
    }
}
