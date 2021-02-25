package eu.senla.task8.mylist;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements MyList<E> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int MAX_ARRAY_CAPACITY = Integer.MAX_VALUE - 8;
    private int size;
    private Object[] myArray;

    public MyArrayList() {
        myArray = new Object[INITIAL_CAPACITY];
    }

    public MyArrayList(MyList<? extends E> col) {
        myArray = col.toArray();
        this.size = myArray.length;
    }

    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            myArray = new Object[capacity];
        } else {
            myArray = new Object[INITIAL_CAPACITY];
            System.out.printf("Capacity of MyArrayList can't be below ZERO. Capacity is: %s", INITIAL_CAPACITY);
        }
    }

    private boolean changeCapacity(int growth, int minGrowth) {
        Object[] oldArray = myArray;
        int newCapacity;

        if (myArray.length + growth <= MAX_ARRAY_CAPACITY) {
            newCapacity = myArray.length + growth;
        } else if (myArray.length + minGrowth <= MAX_ARRAY_CAPACITY) {
            newCapacity = myArray.length + minGrowth;
        } else {
            return false;
        }
        myArray = new Object[newCapacity];

        for (int i = 0; i < oldArray.length; i++) {
            myArray[i] = oldArray[i];
        }
        return true;
    }

    @Override
    public void add(int index, E obj) {
        if (size == myArray.length) {
            if (!changeCapacity(size >> 1, 1)) {
                System.out.println("Can't add element. MyArrayList capacity is full");
                return;
            }
        }

        for (int i = size - 1; i >= index; i--) {
            myArray[i + 1] = myArray[i];
        }
        myArray[index] = obj;
        size++;
    }

    @Override
    public boolean addAll(int index, MyList<? extends E> col) {
        Object[] addArray = col.toArray();

        if (size + addArray.length > myArray.length) {
            int growth = size + addArray.length - myArray.length;
            if (!changeCapacity(growth, growth)) {
                return false;
            }
        }

        for (int i = size - 1; i >= index; i--) {
            myArray[i + addArray.length] = myArray[i];
        }

        for (int i = 0; i < addArray.length; i++) {
            myArray[index + i] = addArray[i];
        }

        return true;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object obj) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object obj) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E set(int index, E obj) {
        return null;
    }

    @Override
    public void sort(Comparator<? super E> comp) {

    }

    @Override
    public List<E> subList(int start, int end) {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] returnArray = new Object[myArray.length];

        for (int i = 0; i < myArray.length; i++) {
            returnArray[i] = myArray[i];
        }

        return returnArray;
    }
}
