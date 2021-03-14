package eu.senla.task9.entity;

import eu.senla.task9.container.ConeContainer;
import eu.senla.task9.container.Container;
import eu.senla.task9.container.CylinderContainer;
import eu.senla.task9.container.SquareContainer;
import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;

public class Deck {

    private static final int DEFAULT_FREE_SPACE = 4;
    private int freeSpace;
    private int numberOfUnits;
    private int massContainersOnDeck;
    private final Container[] containers;

    public Deck() {
        this.freeSpace = DEFAULT_FREE_SPACE;
        this.containers = new Container[freeSpace];
        this.numberOfUnits = 0;
        this.massContainersOnDeck = 0;
    }

    @Override
    public String toString() {
        StringBuilder deckInfo = new StringBuilder();
        for (Container container : containers) {
            if (container != null) {
                deckInfo.append(container);
            }
        }

        return deckInfo.toString();
    }

    public int addContainers() {

        int containerType;
        boolean isFull = false;
        Container container;

        while (!isFull) {

            containerType = RandomUtils.nextInt(1, 4);

            switch (containerType) {
                case 1:
                    container = new ConeContainer(RandomUtils.nextInt(1, 3));
                    break;
                case 2:
                    container = new CylinderContainer(RandomUtils.nextInt(1, 3));
                    break;
                case 3:
                    container = new SquareContainer(RandomUtils.nextInt(1, 3));
                    break;
                default:
                    container = new ConeContainer(RandomUtils.nextInt(1, 3));
                    break;
            }

            if (container.getContainerForm() > freeSpace) {
                isFull = true;
            } else {
                containers[numberOfUnits] = container;
                numberOfUnits++;
                freeSpace -= container.getContainerForm();
                massContainersOnDeck += container.getMass();
                isFull = (freeSpace == 0);
            }
        }
        return massContainersOnDeck;
    }

    public int removeContainers() {
        Arrays.fill(containers, null);
        freeSpace = DEFAULT_FREE_SPACE;
        numberOfUnits = 0;
        massContainersOnDeck = 0;
        return massContainersOnDeck;
    }

    public int getMassContainersOnDeck() {
        return massContainersOnDeck;
    }
}
