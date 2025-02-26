import static org.junit.jupiter.api.Assertions.*;

import org.example.CoffeeNotifier;
import org.example.Observer;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class CoffeeNotifierTest {

    private static class DummyObserver implements Observer {
        private List<String> messages = new ArrayList<>();

        @Override
        public void update(String message) {
            messages.add(message);
        }

        public List<String> getMessages() {
            return messages;
        }
    }

    @Test
    public void testNotifyObservers() {
        CoffeeNotifier notifier = new CoffeeNotifier();

        DummyObserver observer1 = new DummyObserver();
        DummyObserver observer2 = new DummyObserver();

        notifier.attach(observer1);
        notifier.attach(observer2);

        String testMessage = "Café prêt!";
        notifier.notifyObservers(testMessage);

        assertEquals(1, observer1.getMessages().size(), "Observer1 devrait avoir 1 message");
        assertEquals(testMessage, observer1.getMessages().get(0), "Le message de observer1 doit être correct");

        assertEquals(1, observer2.getMessages().size(), "Observer2 devrait avoir 1 message");
        assertEquals(testMessage, observer2.getMessages().get(0), "Le message de observer2 doit être correct");
    }

    @Test
    public void testDetachObserver() {
        CoffeeNotifier notifier = new CoffeeNotifier();
        DummyObserver observer = new DummyObserver();

        notifier.attach(observer);
        notifier.detach(observer);

        notifier.notifyObservers("Message après détachement");

        assertTrue(observer.getMessages().isEmpty(), "Aucun message ne devrait être reçu après détachement");
    }
}
