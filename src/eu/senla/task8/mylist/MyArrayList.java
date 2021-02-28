package eu.senla.task8.mylist;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

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
        this.size = col.size();
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

    private boolean checkIndex(int index, int end) {
        if ((index < 0) || (index > end)) {
            System.out.printf("Index %s out of range from 0 to %s", index, size);
            return true;
        }
        return false;
    }

    @Override
    public void add(int index, E obj) {
        if (checkIndex(index, size)) {
            return;
        }

        if ((size == myArray.length) && (!changeCapacity(size >> 1, 1))) {
            System.out.println("Can't add element. MyArrayList capacity is full");
            return;
        }

        if (index < size) {
            for (int i = size - 1; i >= index; i--) {
                myArray[i + 1] = myArray[i];
            }
        }
        myArray[index] = obj;
        size++;
    }

    @Override
    public boolean addAll(int index, MyList<? extends E> col) {
        if (checkIndex(index, size)) {
            return false;
        }

        Object[] addArray = col.toArray();

        if (size + col.size() > myArray.length) {
            int growth = size + col.size() - myArray.length;
            if (!changeCapacity(growth, growth)) {
                return false;
            }
        }

        if (index < size) {
            for (int i = size - 1; i >= index; i--) {
                myArray[i + col.size()] = myArray[i];
            }
        }

        for (int i = 0; i < col.size(); i++) {
            myArray[index + i] = addArray[i];
        }
        size += col.size();

        return true;
    }

    @Override
    public E get(int index) {
        if (checkIndex(index, size - 1)) {
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
        return new MyArrayList<E>.ListItr(0);
    }

    static <E> MyList<E> of(E... elements) {
        MyList<E> returnList = new MyArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            returnList.add(i, elements[i]);
        }
        return returnList;
    }

    @Override
    public E remove(int index) {
        if (checkIndex(index, size - 1)) {
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

    @Override
    public E set(int index, E obj) {
        if (checkIndex(index, size - 1)) {
            return null;
        }
        E el = (E) myArray[index];
        myArray[index] = obj;
        return el;
    }

    @Override
    public void sort(Comparator<? super E> comp) {
        for (int i = myArray.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if ((myArray[j] != null) && (myArray[j + 1] != null) && (comp.compare((E) myArray[j], (E) myArray[j + 1]) > 0)) {
                    Object el = myArray[j + 1];
                    myArray[j + 1] = myArray[j];
                    myArray[j] = el;
                }
            }
        }
    }

    @Override
    public MyList<E> subList(int start, int end) {
        if (checkIndex(start, size - 1) || checkIndex(end, size)) {
            return null;
        }
        MyList<E> returnList = new MyArrayList<>(end - start);
        for (int i = 0; i < end - start; i++) {
            returnList.add(i, (E) myArray[i + start]);
        }
        return returnList;
    }

    @Override
    public Object[] toArray() {
        Object[] returnArray = new Object[myArray.length];

        for (int i = 0; i < myArray.length; i++) {
            returnArray[i] = myArray[i];
        }

        return returnArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (Object el : myArray) {
            returnString.append(el + ",");
        }
        return returnString.toString();
    }

    private class ListItr implements ListIterator<E> {
        int cursor;
        int lastRet = -1;

        ListItr(int index) {
            cursor = index;
        }

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] myItArray = MyArrayList.this.myArray;
            if (i >= myItArray.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (E) myItArray[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                MyArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        @SuppressWarnings("unchecked")
        public E previous() {
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] myItArray = MyArrayList.this.myArray;
            if (i >= myItArray.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return (E) myItArray[lastRet = i];
        }

        public void set(E e) {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                MyArrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(E e) {
            try {
                int i = cursor;
                MyArrayList.this.add(i, e);
                cursor = i + 1;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
