package eu.senla.task8.main;

import eu.senla.task8.mylist.MyArrayList;
import eu.senla.task8.mylist.MyList;

public class Main {

    public static void main(String[] args) {

        MyList<String> list1 = new MyArrayList<>();
        MyList<String> list2 = new MyArrayList<>(8);

        list1.add(0, "A");
        list1.add(1, "B");
        list1.add(2, "C");

        list2.add(0, "D");
        list2.addAll(0, list1);

        MyList<String> list3 = new MyArrayList<>(list1);

        System.out.println(list3.get(2));

        System.out.printf("List 1: %s", list1);
        System.out.printf("List 2: %s", list2);
        System.out.printf("List 3: %s", list3);

    }
}
