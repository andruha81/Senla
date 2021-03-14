package eu.senla.task9.entity;

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

    @Override
    public String toString() {
        StringBuilder shipInfo = new StringBuilder();

        shipInfo.append(String.format("Ship %s with %s deck(s) amd mass %,d %n", this.name, decks.length, shipMass));
        for (int i = 0; i < decks.length; i++) {
            shipInfo.append(String.format("Deck: %s%n%s", i + 1, decks[i]));
        }

        return shipInfo.toString();
    }

    public String getShortName() {
        return String.format("%s with %s deck(s)", this.name, decks.length);
    }

    public int putContainersOnDeck() {
        for (Deck deck : decks) {
            deck.addContainers();
            shipMass += deck.getMassContainersOnDeck();
        }
        return shipMass;
    }

    public int removeContainersFromDeck() {
        for (Deck deck : decks) {
            deck.removeContainers();
            shipMass = 0;
        }
        return shipMass;
    }

    public int getShipMass() {
        return shipMass;
    }
}
