package eu.senla.task5.entity;

public class Port {

    private static final int MAX_SHIP_NUMBER = 10;
    private int totalShipNumber;
    private int currentShipNumber;
    private final Ship[] ships;

    public Port() {
        this.ships = new Ship[MAX_SHIP_NUMBER];
        this.totalShipNumber = 0;
        this.currentShipNumber = 0;
    }

    public void addShip() {
        Ship ship = new Ship(String.valueOf(++totalShipNumber));
        ship.putContainersOnDeck();
        ships[currentShipNumber] = ship;
        currentShipNumber++;
        System.out.printf("New ship entered the port : %n%s%n", ship);
    }

    public void removeShip() {
        ships[0].removeContainersFromDeck();
        System.arraycopy(ships, 1, ships, 0, ships.length - 1);
        ships[ships.length - 1] = null;
        currentShipNumber--;
    }

}
