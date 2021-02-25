package eu.senla.task8.mylist;

import java.util.Comparator;
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

    @SuppressWarnings("ManualArrayCopy")
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

    private boolean checkIndex(int index) {
        if ((index < 0) || (index >= myArray.length)) {
            System.out.printf("Index %s out of range from 0 to %s", index, myArray.length - 1);
            return true;
        }
        return false;
    }

    @SuppressWarnings("ManualArrayCopy")
    @Override
    public void add(int index, E obj) {
        if (checkIndex(index)) {
            return;
        }

        if ((size == myArray.length) && (!changeCapacity(size >> 1, 1))) {
            System.out.println("Can't add element. MyArrayList capacity is full");
            return;
        }

        for (int i = size - 1; i >= index; i--) {
            myArray[i + 1] = myArray[i];
        }
        myArray[index] = obj;
        size++;
    }

    @SuppressWarnings("ManualArrayCopy")
    @Override
    public boolean addAll(int index, MyList<? extends E> col) {
        if (checkIndex(index)) {
            return false;
        }

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
        size += addArray.length;

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (checkIndex(index)) {
            return null;
        }
        return (E) myArray[index];
    }

    @Override
    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (myArray[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < myArray.length; i++) {
                if (myArray[i].equals(obj)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (myArray[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (myArray[i].equals(obj)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @SuppressWarnings({"unchecked", "ManualArrayCopy"})
    @Override
    public E remove(int index) {
        if (checkIndex(index)) {
            return null;
        }
        E el = (E) myArray[index];

        for (int i = index + 1; i < size; i++) {
            myArray[i - 1] = myArray[i];
        }
        myArray[size - 1] = null;
        size--;
        return el;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E obj) {
        if (checkIndex(index)) {
            return null;
        }
        E el = (E) myArray[index];
        myArray[index] = obj;
        return el;
    }

    @Override
    public void sort(Comparator<? super E> comp) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public MyList<E> subList(int start, int end) {
        if (checkIndex(start) || checkIndex(end + 1)) {
            return null;
        }
        MyList<E> returnList = new MyArrayList<>(end - start + 1);
        for (int i = 0; i < end; i++) {
            returnList.add(i, (E) myArray[i]);
        }
        return returnList;
    }

    @SuppressWarnings("ManualArrayCopy")
    @Override
    public Object[] toArray() {
        Object[] returnArray = new Object[myArray.length];

        for (int i = 0; i < myArray.length; i++) {
            returnArray[i] = myArray[i];
        }

        return returnArray;
    }
}
