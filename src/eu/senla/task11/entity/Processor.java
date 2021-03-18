package eu.senla.task11.entity;

public class Processor {

    private final String producer;
    private final String model;
    private final double frequency;
    private final int cores;

    public Processor(String producer, String model, double frequency, int cores) {
        this.producer = producer;
        this.model = model;
        this.frequency = frequency;
        this.cores = cores;
    }

    @Override
    public String toString() {
        return String.format("Processor: producer %s, model %s; frequency %.2f GHz, cores %d", producer, model, frequency, cores);
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCores() {
        return cores;
    }
}
