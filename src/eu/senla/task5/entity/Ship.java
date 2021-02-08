package eu.senla.task5.entity;

import org.apache.commons.lang3.RandomUtils;

public class Ship {

    private final Deck[] decks;
    private final String name;
    private int shipMass;

    public Ship(String name) {
        this.name = name;
        decks = new Deck[RandomUtils.nextInt(1, 3)];
        shipMass = 0;

        for (int i = 0; i < decks.length; i++) {
            decks[i] = new Deck();
        }
    }

    public void putContainersOnDeck() {
        for (Deck deck : decks) {
            deck.addContainers();
            shipMass += deck.getMassContainersOnDeck();
        }
    }

    public void removeContainersFromDeck() {
        for (Deck deck : decks) {
            deck.removeContainers();
            shipMass = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder shipInfo = new StringBuilder();

        shipInfo.append(String.format("Ship %s with %s deck(s) amd mass %s%n", name, decks.length, shipMass));
        for (int i = 0; i < decks.length; i++) {
            shipInfo.append(String.format("Deck: %s%n%s", i + 1, decks[i]));
        }

        return shipInfo.toString();
    }
}
