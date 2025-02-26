import org.example.CafeAuLait;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CafeAuLaitTest {
    @Test
    void testGetDescription() {
        CafeAuLait CafeAuLait = new CafeAuLait();
        Assertions.assertEquals("Café au lait", CafeAuLait.getDescription(), "'Café au lait' est attendu");
    }
    @Test
    void testGetCost() {
        CafeAuLait CafeAuLait = new CafeAuLait();
        Assertions.assertEquals(2.5, CafeAuLait.getCost(), "Le prix attendu est '2.0'");
    }
}
