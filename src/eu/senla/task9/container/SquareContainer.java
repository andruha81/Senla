package eu.senla.task9.container;

public class SquareContainer extends Container {

    public SquareContainer(int containerType) {
        super(containerType);
    }

    @Override
    public String toString() {
        return String.format("Square container, %s, with height: %,dm, volume: %,dm3, water density: %,dkg/m3, mass: %,dkg %n", form, height, volume, density, mass);
    }

    @Override
    void countVolume() {
        volume = (int) (Math.pow(diagonal, 2.0) / 2 * height);
    }
}
