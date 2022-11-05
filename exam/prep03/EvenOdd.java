package exam.prep03;

import static org.junit.Assert.*;
import org.junit.Test;
import week2.IntList;

public class EvenOdd {
    public static void evenOdd(IntList L) {
        IntList lastEven, lastIntList;
        lastEven = lastIntList = L;
        int i = 1;
        for (IntList ptr = L.next; ptr != null;) {
            if (i % 2 == 0) {
                IntList next = ptr.next;
                lastIntList.next = next;
                ptr.next = lastEven.next;
                lastEven.next = ptr;
                lastEven = ptr;
                ptr = next;
            } else {
                lastIntList = ptr;
                ptr = ptr.next;
            }
            i += 1;
        }
    }

    @Test
    public void testEvenOdd() {
        IntList L = IntList.of(0, 3, 1, 4, 2, 5);
        // IntList correctResult = IntList.of(0, 1, 2, 3, 4, 5);
        evenOdd(L);
        L.print();
        // correctResult.print();
    }
}
