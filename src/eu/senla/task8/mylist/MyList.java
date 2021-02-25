package eu.senla.task8.mylist;

import java.util.Comparator;
import java.util.ListIterator;

public interface MyList<E> {
    void add(int index, E obj);

    boolean addAll(int index, MyList<? extends E> col);

    E get(int index);

    int indexOf(Object obj);

    int lastIndexOf(Object obj);

    ListIterator<E> listIterator();

    static <E> MyList<E> of() {
        return null;
    }

    E remove(int index);

    E set(int index, E obj);

    void sort(Comparator<? super E> comp);

    MyList<E> subList(int start, int end);

    Object[] toArray();
}
