package eu.senla.task5;

import eu.senla.task5.entity.Port;
import org.apache.commons.lang3.RandomUtils;

public class Main {

    private static final int FIRST_SHIPS = 5;
    private static final int TOTAL_IN_OUT = 100;
    private static final String PORT_NAME = "Rotterdam";

    public static void main(String[] args) {

        Port port = new Port(PORT_NAME);

        for (int i = 0; i < FIRST_SHIPS; i++) {
            port.addShip();
        }

        for (int i = 0; i < TOTAL_IN_OUT; i++) {
            if (RandomUtils.nextInt(1, 3) == 1) {
                port.addShip();
            } else {
                port.removeShip();
            }
        }
    }
}
