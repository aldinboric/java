package project.proj01;

import static java.lang.System.out;
import static java.lang.System.arraycopy;

/** Generična niz-lista sa O(1) pristupom, brisanjem i dodavanjem osim u slučaju resize-ovanja. */
public class ArrayDeque<SType> {
    private interface LambdaFunction {
        boolean apply(int size, int arraysize);
    }
    private static final LambdaFunction checkForResizeDown = (x, y) -> (double) (x - 1) / y < 0.25 && y > 10;
    private SType[] _array;
    private int _size;
    private int _index0;
    private int _index1;

    /** Konstruktor za prazan niz početne veličine osam. */
    public ArrayDeque() {
        _array = (SType[]) new Object[10];
        _index1 = (_array.length - _size) / 2;
        _index0 = _index1 - 1;
        _size = 0;
    }

    /** Vraća niz. */
    public SType[] getArray() {
        return _array;
    }

    /** Provjerava da li je niz prazan. */
    public boolean isEmpty() {
        return _size == 0;
    }

    /** Vraća trenutnu veličinu niza. */
    public int size() {
        return _size;
    }

    /** Mijenja veličinu niza. */
    public void resize(int size) {
        SType[] array = (SType[]) new Object[size];
        int index0 = (array.length - _size) / 2;
        _index0 += 1;
        for (int i = 0; i < _size; i += 1, _index0 += 1, index0 += 1) {
            if (_index0 == _array.length)
                _index0 = 0;
            array[index0] = _array[_index0];
        }
        _index1 = index0;
        _index0 = (index0 - _size) - 1;
        _array = array;
    }

    /** Dodaje novi item na početak niza. */
    public void addFirst(SType item) {
        if (_array.length == _size)
            resize(_array.length * 2);
        else if (_index0 == -1)
            _index0 = _array.length - 1;
        _array[_index0] = item;
        _index0 -= 1; _size += 1;
    }

    /** Dodaje novi item na kraj niza. */
    public void addLast(SType item) {
        if (_array.length == _size)
            resize(_array.length * 2);
        else if (_index1 == _array.length)
            _index1 = 0;
        _array[_index1] = item;
        _index1 += 1; _size += 1;
    }

    /** Briše prvi item niza. */
    public SType removeFirst() {
        if (_size == 0)
            return null;
        else if (checkForResizeDown.apply(_size, _array.length))
            resize(_array.length / 2);
        else if (_index0 == _array.length - 1 && _size > 0)
            _index0 = -1;
        _index0 += 1; _size -= 1;
        SType item = _array[_index0];
        _array[_index0] = null;
        return item;
    }

    /** Briše posljednji item niza. */
    public SType removeLast() {
        if (_size == 0)
            return null;
        else if (checkForResizeDown.apply(_size, _array.length))
            resize(_array.length / 2);
        else if (_index1 == 0 && _size > 0)
            _index1 = _array.length;
        _index1 -= 1; _size -= 1;
        SType item = _array[_index1];
        _array[_index1] = null;
        return item;
    }

    /** Vraća i-ti item niza. */
    public SType get(int index) {
        if (_size == 0)
            return null;
        index = index + (_index0 + 1) >= _array.length ? (index + (_index0 + 1)) - _array.length
                                                       : index + (_index0 + 1);
        return _array[index];
    }

    /** Vraća niz u obliku stringa. */
    @Override
    public String toString() {
        String result = "<";
        int index0 = _index0 + 1;
        for (int i = 0; i < _size; i += 1, result += _array[index0] + " ", index0 += 1)
            if (index0 == _array.length)
                index0 = 0;
        return result + ">";
    }

    /* Printa niz. */
    public void printDeque() {
        out.println(this.toString());
    }
}
