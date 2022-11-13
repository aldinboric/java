package project.proj01;

import java.util.Iterator;

public interface Deque<T> extends Iterable<T> {
    boolean isEmpty();
    int size();
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    T get(int index);
    String toString();
    void printDeque();
    boolean simpleIsEqual(Object o);
}
