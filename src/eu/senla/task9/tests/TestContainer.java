package eu.senla.task9.tests;

import eu.senla.task9.container.ConeContainer;
import eu.senla.task9.container.Container;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestContainer {

    private final Container container = new ConeContainer(1);

    @Test
    void testCOntainerFormSmall() {
        Container container = new ConeContainer(1);
        Assertions.assertEquals(1, container.getContainerForm());
    }

    @Test
    void testCOntainerFormBig() {
        Container container = new ConeContainer(2);
        Assertions.assertEquals(2, container.getContainerForm());
    }

    @Test
    void testMassNotZero() {
        Assertions.assertNotEquals(0, container.getMass());
    }

    @Test
    void toStringNotEmpty() {
        Assertions.assertNotEquals("", container);
    }

    @Test
    void toStringNotSpace() {
        Assertions.assertNotEquals(" ", container);
    }
}
