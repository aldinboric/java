package week4;

import edu.princeton.cs.algs4.ST;

import java.util.Iterator;

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

    public Iterator<SType> iterator() {
        return new ArraySetIterator();
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
    }
}
