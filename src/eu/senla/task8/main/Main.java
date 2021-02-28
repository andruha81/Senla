package eu.senla.task8.main;

import eu.senla.task8.mylist.MyArrayList;
import eu.senla.task8.mylist.MyList;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        MyList<String> list1 = new MyArrayList<>();
        MyList<String> list2 = new MyArrayList<>(8);

        list1.add(0, "A");
        list1.add(1, "B");
        list1.add(2, "C");

        list2.add(0, "D");
        list2.add(0, "E");
        list2.add(0, "B");

        System.out.println("List1: " + list1);
        System.out.printf("List2: %s%n", list2);

        if (list1.addAll(0, list2)) {
            System.out.printf("List1 after adding list2: %s%n", list1);
        }

        System.out.printf("The first index of element B in list1 is: %s%n", list1.indexOf("B"));
        System.out.printf("The last index of element B in list1 is: %s%n", list1.lastIndexOf("B"));

        System.out.printf("Element removing from index 2 in list1 is:  %s%n", list1.remove(2));

        MyList<String> list3 = new MyArrayList<>(list1);

        System.out.printf("List3: %s%n", list3);
        System.out.printf("Second element from list3 is: %s%n", list3.get(2));

        MyList<String> list4 = list3.subList(1, 3);
        System.out.printf("List4, sublist of list3 from 1(inclusive) to 3(exclusive) index: %s%n", list4);
        System.out.printf("Element in index 0 is set from %s to Z in list4 %n", list4.set(0, "Z"));

        System.out.printf("List3 unsorted: %s%n", list3);

        list3.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.printf("List3 sorted: %s%n", list3);

    }
}
