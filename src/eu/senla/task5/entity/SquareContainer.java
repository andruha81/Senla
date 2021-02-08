package eu.senla.task5.entity;

public class SquareContainer extends Container {

    public SquareContainer(int containerType) {
        super(containerType);
    }

    @Override
    public String toString() {
        return String.format("Square container, %s, with height: %s, volume: %s, water density: %s, mass: %s%n", form, height, volume, density, mass);
    }

    @Override
    void countVolume() {
        volume = Math.pow(diagonal, 2) / 2 * height;
    }
}
