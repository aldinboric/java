package lab.lab07;

import java.security.Key;
import java.util.Comparator;

public class BSTMapComparator {
    public static class BSTComparator<SType> implements Comparator<SType> {
        @Override
        public int compare(SType key1, SType key2) {
            if (key1 instanceof Integer)
                return (Integer) key1 - (Integer) key2;
            else if (key1 instanceof String)
                return ((String) key1).compareTo((String) key2);
            else if (key1 instanceof Character)
                return ((Character) key1).compareTo((Character) key2);
            else
                throw new UnsupportedOperationException();
        }
    }

    public static <SType> int compareKeys(SType key1, SType key2) {
        return new BSTComparator<SType>().compare(key1, key2);
    }
}
