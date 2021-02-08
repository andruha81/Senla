package eu.senla.task5.entity;

import org.apache.commons.lang3.RandomUtils;

public abstract class Container {

    protected static final double MIN_DIAGONAL = 10;
    protected static final int MIN_HEIGHT = 10;
    protected static final int MAX_HEIGHT = 100;
    protected static final int FIRST_DENSITY = 1000;
    protected static final int SECOND_DENSITY = 2000;

    protected double diagonal;
    protected double height;
    protected double volume;
    protected int mass;
    protected int density;
    protected int containerForm;
    protected String form;

    public Container(int containerForm) {
        this.containerForm = containerForm;
        this.diagonal = MIN_DIAGONAL * this.containerForm;
        this.height = RandomUtils.nextInt(MIN_HEIGHT, MAX_HEIGHT + 1);
        this.form = this.containerForm == 1 ? "small" : "big";

        if (RandomUtils.nextInt(1, 3) == 1) {
            density = FIRST_DENSITY;
        } else {
            density = SECOND_DENSITY;
        }

        countMass();
    }

    @Override
    public String toString() {
        return String.format("Container with height: %s, volume: %s, water density: %s, mass: %s%n", height, volume, density, mass);
    }

    abstract void countVolume();

    protected void countMass() {
        countVolume();
        this.mass = (int) this.volume * density;
    }

    public int getContainerForm() {
        return this.containerForm;
    }

    public int getMass() {
        return this.mass;
    }
}
