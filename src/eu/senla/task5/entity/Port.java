package eu.senla.task5.entity;

public class Port {

    private static final int MAX_SHIP_NUMBER = 10;
    private final String name;
    private int totalShipNumber;
    private int currentShipNumber;
    private int currentContainerMass;
    private int totalContainerMass;
    private final Ship[] ships;

    public Port(String name) {
        this.ships = new Ship[MAX_SHIP_NUMBER];
        this.name = name;
        this.totalShipNumber = 0;
        this.currentShipNumber = 0;
        this.currentContainerMass = 0;
        this.totalContainerMass = 0;
    }

    @Override
    public String toString() {
        return String.format("Port %s", name);
    }

    public void addShip() {
        if (currentShipNumber < MAX_SHIP_NUMBER) {
            Ship ship = new Ship(String.valueOf(++totalShipNumber));
            ship.putContainersOnDeck();
            ships[currentShipNumber] = ship;
            currentShipNumber++;
            currentContainerMass += ship.getShipMass();
            totalContainerMass += ship.getShipMass();
            System.out.printf("New ship arrived to the %s : %n%s", this, ship);
            System.out.printf("There are %s ships in the %s with total mass %,dkg %n", currentShipNumber, this, currentContainerMass);
            System.out.printf("%s summary mass of all ships %,dkg %n", this, totalContainerMass);
            System.out.println("-----------------");
        } else {
            System.out.println("There is no free space in port for new ship");
        }
    }

    public void removeShip() {
        if (currentShipNumber > 0) {
            Ship ship = ships[0];
            System.out.printf("Ship %s left the %s %n", ship.getShortName(), this);
            currentContainerMass -= ships[0].getShipMass();
            ships[0].removeContainersFromDeck();
            System.arraycopy(ships, 1, ships, 0, ships.length - 2);
            currentShipNumber--;
            System.out.printf("There are %s ships in the %s with total mass %,dkg %n", currentShipNumber, this, currentContainerMass);
            System.out.println("-----------------");
        }
    }
}
