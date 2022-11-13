package project.proj01;

import java.util.Comparator;

public interface MaxDeque<T> extends Deque<T> {
    public T max();
    public T max(Comparator<T> comparator);
}
