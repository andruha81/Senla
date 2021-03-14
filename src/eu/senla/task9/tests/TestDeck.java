package eu.senla.task9.tests;

import eu.senla.task9.entity.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDeck {

    private final Deck deck = new Deck();

    @Test
    void addContainersMassNotZero() {
        Assertions.assertNotEquals(0, deck.addContainers());
    }

    @Test
    void removeContainersMassZero() {
        Assertions.assertEquals(0, deck.removeContainers());
    }

    @Test
    void returningMassAfterAddingContainers() {
        int containersMass = deck.addContainers();
        Assertions.assertEquals(containersMass, deck.getMassContainersOnDeck());
    }

    @Test
    void toStringNotEmpty() {
        Assertions.assertNotEquals("", deck);
    }

    @Test
    void toStringNotSpace() {
        Assertions.assertNotEquals(" ", deck);
    }
}
