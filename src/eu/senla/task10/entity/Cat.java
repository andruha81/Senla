package eu.senla.task10.entity;

public class Cat {

    public static final String DEFAULT_NAME = "Murzik";
    public static final int DEFAULT_AGE = 5;
    private final String name;
    private final int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Cat name %s, age %s", this.name, this.age);
    }
}
