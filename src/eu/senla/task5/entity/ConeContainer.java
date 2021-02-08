package eu.senla.task5.entity;

public class ConeContainer extends Container{

    public ConeContainer(int containerType) {
        super(containerType);
    }

    @Override
    public String toString() {
        return String.format("Cone container, %s, with height: %s, volume: %s, water density: %s, mass: %s%n", form, height, volume, density, mass);
    }

    @Override
    void countVolume() {
        volume = Math.PI * Math.pow(diagonal / 2, 2) * (height / 3);
    }
}
