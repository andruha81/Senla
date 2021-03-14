package eu.senla.task9.container;

public class ConeContainer extends Container {

    public ConeContainer(int containerType) {
        super(containerType);
    }

    @Override
    public String toString() {
        return String.format("Cone container, %s, with height: %,dm, volume: %,dm3, water density: %,dkg/m3, mass: %,dkg %n", form, height, volume, density, mass);
    }

    @Override
    void countVolume() {
        volume = (int) (Math.PI * Math.pow(diagonal / 2.0, 2) * (height / 3.0));
    }
}
