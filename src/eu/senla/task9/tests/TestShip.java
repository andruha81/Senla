package eu.senla.task9.tests;

import eu.senla.task9.entity.Ship;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestShip {

    private final Ship ship = new Ship("Test ship");

    @Test
    void putContainersShipMassNotZero() {
        Assertions.assertNotEquals(0, ship.putContainersOnDeck());
    }

    @Test
    void removeContainersShipMassNotZero() {
        Assertions.assertEquals(0, ship.removeContainersFromDeck());
    }

    @Test
    void testReturningShipMass() {
        int shipMass = ship.putContainersOnDeck();
        Assertions.assertEquals(shipMass, ship.getShipMass());
    }

    @Test
    void shortNameNotEmpty() {
        Assertions.assertNotEquals("", ship.getShortName());
    }

    @Test
    void shortNameNotSpace() {
        Assertions.assertNotEquals(" ", ship.getShortName());
    }

    @Test
    void toStringNotEmpty() {
        Assertions.assertNotEquals("", ship);
    }

    @Test
    void toStringNotSpace() {
        Assertions.assertNotEquals(" ", ship);
    }
}
