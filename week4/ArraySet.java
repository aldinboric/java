package week4;

import edu.princeton.cs.algs4.ST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;
import static java.lang.System.arraycopy;

public class ArraySet<SType> implements Iterable<SType> {
    private SType[] _array;
    private int _size;

    private static final int _FACTOR = 2;

    public ArraySet() {
        _array = (SType[]) new Object[100];
        _size = 0;
    }

    public static <T> ArraySet<T> of(T... vargs) {
        ArraySet<T> arr = new ArraySet<>();
        for (T item : vargs)
            arr.add(item);
        return arr;
    }

    public int size() {
        return _size;
    }

    private void resize(int size) {
        SType[] array = (SType[]) new Object[size];
        arraycopy(_array, 0, array, 0, _size);
        _array = array;
    }

    public void add(SType value) {
        if (value == null)
            throw new IllegalArgumentException("Null vrijednost se ne moze dodati u niz!");
        else if (this.contains(value))
            return;
        else if (_size == _array.length)
            resize(_array.length * _FACTOR);
        _array[_size] = value;
        _size += 1;
    }

    public SType removeLast() {
        if ((double) _size / _array.length <  0.25)
            resize(_array.length / _FACTOR);
        SType val = _array[_size - 1];
        _array[_size - 1] = null;
        _size -= 1;
        return val;
    }

    public boolean contains(SType value) {
        for (int i = 0; i < _size; i += 1)
            if (_array[i].equals(value))
                return true;
        return false;
    }

    private class ArraySetIterator implements Iterator<SType> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            if (currentIndex < _array.length && _array[currentIndex] != null)
                return true;
            return false;
        }
        @Override
        public SType next() {
            SType tmp = _array[currentIndex];
            currentIndex += 1;
            return tmp;
        }
    }

    @Override
    public Iterator<SType> iterator() {
        return new ArraySetIterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < _size - 1; result.append(_array[i]).append(" "), i += 1);
        return result.append(_array[_size - 1]).append("]").toString();
    }

    private String toString2() {
        List<String> listOfItems = new ArrayList<>();
        for (SType item : this)
            listOfItems.add(item.toString());
        return "[" + String.join(", ", listOfItems) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArraySet newArraySet) {
            if (this._size != newArraySet._size)
                return false;
            for (SType item : _array)
                if (!(newArraySet.contains(item)))
                    return false;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArraySet<Integer> arr = new ArraySet<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Iterator<Integer> arrIter = arr.iterator();
        while (arrIter.hasNext())
            out.println(arrIter.next());
        for (int x : arr)
            out.println(x);
        out.println(arr);
    }
}
