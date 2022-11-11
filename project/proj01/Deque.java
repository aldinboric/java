package project.proj01;

public interface Deque<T> {
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
