package eu.senla.task3;

import eu.senla.task3.entity.Cat;

public class Main {

    public static void main(String[] args) {

        int catNumber = 10;
        int catCount = 0;

        System.out.println("First cycle *****");

        while (catCount < catNumber) {
            Cat cat = new Cat();
            catCount++;
            System.out.printf("Cat default name is %s, default age is %s%n", cat.getName(), cat.getAge());
        }

        System.out.println("Second cycle *****");

        for (catCount = 0; catCount < catNumber; catCount++) {
            Cat cat = new Cat();
            cat.setName("Vaska");
            cat.setAge(9);
            System.out.printf("Cat name is %s, age is %s%n", cat.getName(), cat.getAge());
        }

        System.out.println("Third cycle *****");

        catCount = 0;
        do {
            Cat cat = new Cat("Murka", 2);
            catCount++;
            System.out.printf("Cat name is %s, age is %s%n", cat.getName(), cat.getAge());
        } while (catCount < catNumber);

        System.out.println("Fourth cycle *****");

        Cat[] cats = {new Cat("Konfetka", 3), new Cat("Vaska", 6),
                new Cat("Murzik", 9), new Cat("Barsik", 4), new Cat("Murka", 1)};

        for (Cat cat : cats) {
            System.out.println(cat.toString());
        }
    }
}
