package project.proj01;

import java.util.Iterator;

public interface Deque<T> extends Iterable<T> {
    /** Provjerava da li je niz prazan. */
    default boolean isEmpty() { return this.size() == 0; }
    int size();
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    T get(int index);
    String toString();
    void printDeque();
}
