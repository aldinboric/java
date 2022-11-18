package exam.prep05;

import java.rmi.NoSuchObjectException;
import java.util.*;

import static java.lang.System.out;

public class IteratorOfIteratorsTask {
    public static class IteratorOfIterators implements Iterable<Integer> {
        private final List<Iterator<Integer>> _iteratorList;
        private Set<Iterator<Integer>> _iteratorsExpiredSet;
        private int _iteratorIndex;

        public IteratorOfIterators(List<Iterator<Integer>> input) {
            _iteratorList = input;
            _iteratorsExpiredSet = new HashSet<Iterator<Integer>>();
            _iteratorIndex = 0;
        }

        @Override
        public Iterator<Integer> iterator() {
            class IterableHelper implements Iterator<Integer> {
                @Override
                public boolean hasNext() {
                    return _iteratorsExpiredSet.size() < _iteratorList.size();
                }
                @Override
                public Integer next() {
                    if (_iteratorsExpiredSet.size() >= _iteratorList.size())
                        throw new NoSuchElementException();
                    _iteratorIndex += 1;
                    boolean hasNext = _iteratorList.get((_iteratorIndex - 1) % _iteratorList.size()).hasNext();
                    if (hasNext)
                        return _iteratorList.get(_iteratorIndex - 1 == _iteratorList.size() ? 0 : (_iteratorIndex - 1) % _iteratorList.size()).next();
                    _iteratorsExpiredSet.add(_iteratorList.get((_iteratorIndex - 1) % _iteratorList.size()));
                    return this.next();
                }
            }
            return new IterableHelper();
        }
    }

    public static void main(String[] args) {
        List<Integer> L1 = new ArrayList<>();
        List<Integer> L2 = new ArrayList<>();
        List<Integer> L3 = new ArrayList<>();

        L1.add(1); L1.add(3);
        L1.add(4); L1.add(5);
        L3.add(2);

        Iterator<Integer> I1 = L1.iterator();
        Iterator<Integer> I2 = L2.iterator();
        Iterator<Integer> I3 = L3.iterator();

        List<Iterator<Integer>> LI = new ArrayList<>();
        LI.add(I1); LI.add(I2); LI.add(I3);

        IteratorOfIterators IOI1 = new IteratorOfIterators(LI);
        for (int x : IOI1)
            out.print(x + " ");
        out.println();
    }
}
