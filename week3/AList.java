package week3;

import static java.lang.System.arraycopy;

public class AList<T> {
    private T[] array;
    int size;

    public AList() {
        array = (T[]) new Object[10];
        size = 0;
    }

    public void addLast(T item) {
        if (size == array.length)
            resize(array.length * 2);
        array[size] = item;
        size += 1;
    }

    public T getLast() {
        return array[size - 1];
    }

    public T get(int i) {
        return array[i];
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        T item = array[size - 1];
        array[size - 1] = null;
        size -= 1;
        if ((double) size / array.length < 0.25)
            resize(array.length / 2);
        return item;
    }

    public void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
