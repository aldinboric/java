package exam.prep05;

import java.util.*;

import static java.lang.System.out;

public class FilteredListTask {
    public interface Predicate<T> {
        boolean test(T x);
    }

    public static class Test<T> implements Predicate<T> {
        @Override
        public boolean test(T item) {
            if (item instanceof String)
                return ((String) item).length() % 2 == 0;
            else if (item instanceof Integer)
                return (Integer) item % 2 == 0 && (Integer) item != 0;
            return false;
        }
    }

    public static class FilteredList<T> implements Iterable<T> {
        private List<T> _list;
        private int _listIndex;
        private Predicate<T> _filter;

        public FilteredList(List<T> L, Predicate<T> F) {
            _list = L;
            _listIndex = 0;
            _filter = F;
        }

        @Override
        public Iterator<T> iterator() {
            class HelperCl implements Iterator<T> {
                @Override
                public boolean hasNext() {
                    return _listIndex < _list.size();
                }
                @Override
                public T next() {
                    if (_listIndex >= _list.size())
                        throw new NoSuchElementException();
                    while (!(_filter.test(_list.get(_listIndex))))
                        _listIndex += 1;
                    T item = _list.get(_listIndex);
                    _listIndex += 1;
                    return item;
                }
            }
            return new HelperCl();
        }
    }

    public static void main(String[] args) {
        Predicate<Integer> P = new Test<>();
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < 10; L.add(i), i += 1);
        FilteredList<Integer> FL = new FilteredList<>(L, P);
        for (int item : FL)
            out.print(item + " ");
        out.println();
    }
}
