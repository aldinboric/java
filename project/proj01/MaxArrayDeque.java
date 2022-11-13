package project.proj01;

import java.lang.reflect.Array;
import java.util.Comparator;
import static java.lang.System.out;

public class MaxArrayDeque<SType> extends ArrayDeque<SType> implements MaxDeque<SType> {
    private Comparator<SType> _comparator;

    /** Konstruktor koji prima komparator. */
    public MaxArrayDeque(Comparator<SType> comparator) {
        super();
        _comparator = comparator;
    }

    /** Vraća najveći item niza. */
    @Override
    public SType max() {
        SType maxItem = this.get(0);
        for (SType item : this)
            if (_comparator.compare(item, maxItem) > 0)
                maxItem = item;
        return maxItem;
    }

    /** Uspoređuje iteme niza pomoću novog comparatora. */
    @Override
    public SType max(Comparator<SType> comparator) {
        _comparator = comparator;
        return this.max();
    }
}
