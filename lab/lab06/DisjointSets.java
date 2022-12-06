package lab.lab06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.System.out;

public class DisjointSets {
    public static class UnionFind {
        private final int[] _parents;
        private int _numberOfSubUnions;

        public UnionFind(int size) {
            _numberOfSubUnions = size;
            _parents = new int[size];
            Arrays.fill(_parents, -1);
        }

        public void validate(int value) {
            if (value < 0 || value >= _parents.length)
                throw new IllegalArgumentException();
        }

        public int subunions() {
            return _numberOfSubUnions;
        }

        public int sizeOf(int value) {
            validate(value);
            return Math.abs(_parents[find(value)]);
        }

        public int parent(int value) {
            validate(value);
            return _parents[value] < 0 ? value : _parents[value];
        }

        public int find(int value) {
            validate(value);
            List<Integer> valCache = new ArrayList<>();
            for (int i = 0; value != parent(value); i += 1) {
                valCache.add(value);
                value = parent(value);
            }
            for (int val : valCache)
                _parents[val] = value;
            return value;
        }

        public boolean connected(int value1, int value2) {
            return find(value1) == find(value2);
        }

        public void union(int value1, int value2) {
            validate(value1);
            validate(value2);
            int val1parent = find(value1);
            int val2parent = find(value2);
            if (val1parent == val2parent);
            else if (_parents[val1parent] <= _parents[val2parent]) {
                _parents[val1parent] += _parents[val2parent];
                _parents[val2parent] = val1parent;
            } else {
                _parents[val2parent] += _parents[val1parent];
                _parents[val1parent] = val2parent;
            }
        }
    }

    public static void main(String[] args) {
        UnionFind DS = new UnionFind(16);

        DS.union(8, 14);
        DS.union(2, 9);
        DS.union(2, 8);

        DS.union(0, 4);
        DS.union(3, 10);
        DS.union(0, 3);
        DS.union(0, 2);

        DS.union(5, 12);
        DS.union(11, 15);
        DS.union(5, 11);

        DS.union(1, 7);
        DS.union(6, 13);
        DS.union(1, 6);
        DS.union(1, 5);

        DS.union(0, 1);

        out.println(DS.connected(15, 10));
        out.println(DS.connected(13, 14));
    }
}
