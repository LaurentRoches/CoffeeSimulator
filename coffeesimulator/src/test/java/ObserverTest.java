import org.example.CoffeeNotifier;
import org.example.Observer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObserverTest {

    private static class DummyObserver implements Observer {
        private List<String> notifications = new ArrayList<>();

        @Override
        public void update(String message) {
            notifications.add(message);
        }

        public List<String> getNotifications() {
            return notifications;
        }
    }

    @Test
    public void testNotifyObservers() {
        CoffeeNotifier notifier = new CoffeeNotifier();

        DummyObserver observer1 = new DummyObserver();
        DummyObserver observer2 = new DummyObserver();

        notifier.attach(observer1);
        notifier.attach(observer2);

        String testMessage = "Nouvelle commande de café!";
        notifier.notifyObservers(testMessage);

        assertEquals(1, observer1.getNotifications().size(), "Observer1 devrait avoir 1 notification");
        assertEquals(testMessage, observer1.getNotifications().get(0), "Le message reçu par observer1 doit être correct");

        assertEquals(1, observer2.getNotifications().size(), "Observer2 devrait avoir 1 notification");
        assertEquals(testMessage, observer2.getNotifications().get(0), "Le message reçu par observer2 doit être correct");
    }

    @Test
    public void testDetachObserver() {
        CoffeeNotifier notifier = new CoffeeNotifier();
        DummyObserver observer = new DummyObserver();

        notifier.attach(observer);
        notifier.detach(observer);

        notifier.notifyObservers("Message après détachement");

        assertTrue(observer.getNotifications().isEmpty(), "Aucune notification ne devrait être reçue après détachement");
    }
}
