package eu.senla.task9.tests;

import eu.senla.task9.entity.Port;
import eu.senla.task9.entity.Ship;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPort {

    private final Port port = new Port("Test port");

    @Test
    void addedShipNotNull() {
        Assertions.assertNotEquals(null, port.addShip());
    }

    @Test
    void removeAddedShip() {
        Ship ship = port.addShip();
        Assertions.assertEquals(ship, port.removeShip());
    }

    @Test
    void removingFromEmptyPort() {
        Assertions.assertEquals(null, port.removeShip());
    }

    @Test
    void toStringNotEmpty() {
        Assertions.assertNotEquals("", port);
    }

    @Test
    void toStringNotSpace() {
        Assertions.assertNotEquals(" ", port);
    }
}
