package project.proj01;

import org.junit.Test;
import java.util.ArrayList;
import java.util.ArrayList;
import edu.princeton.cs.algs4.StdRandom;

import static org.junit.Assert.*;
import static java.lang.System.out;

public class ArrayDequeTest {
    /** Resize testovi. */
    @Test
    public void resizeTestSet() {
        /* Test Set 1 */
        ArrayDeque<Integer> AL = new ArrayDeque<>();
        /* Popuni sve. */
        for (int i = 19, j = 20; i > -1; i -= 1, j += 1) {
            AL.addFirst(i);
            AL.addLast(j);
        }

        /* Izbriši sve i testiraj na prazno. */
        AL.addLast(40);
        for (int i = 0; i < 50; i += 1)
            AL.removeFirst();

        assertArrayEquals(new Integer[]{null, null, null, null, null, null, null, null, null, null}, AL.getArray());
    }

    /** addFirst, removeFirst testovi. */
    @Test
    public void addRemoveFirstTestSet() {
        /* Test Set 1 */
        ArrayDeque<Integer> AL = new ArrayDeque<>();
        /* Popuni sve. */
        for (int i = 4; i > -1; i -= 1)
            AL.addFirst(i);
        for (int i = 5; i < 10; i += 1)
            AL.addLast(i);

        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, AL.getArray());
        AL.printDeque();

        /* Ukloni sve. */
        for (int i = 0; i < 10; i += 1)
            AL.removeFirst();

        assertArrayEquals(new Integer[]{null, null, null, null, null, null, null, null, null, null}, AL.getArray());
        AL.printDeque();

        /* Popuni sve. */
        for (int i = 4; i > -1; i -= 1)
            AL.addFirst(i);
        for (int i = 5; i < 10; i += 1)
            AL.addLast(i);

        assertArrayEquals(new Integer[]{5, 6, 7, 8, 9, 0, 1, 2, 3, 4}, AL.getArray());
        AL.printDeque();

        /* Ukloni sve. */
        for (int i = 0; i < 10; i += 1)
            AL.removeFirst();

        assertArrayEquals(new Integer[]{null, null, null, null, null, null, null, null, null, null}, AL.getArray());
        AL.printDeque();

        /* Popuni sa jednim brojem više. */
        for (int i = 4; i > -1; i -= 1)
            AL.addFirst(i);
        for (int i = 5; i < 11; i += 1)
            AL.addLast(i);

        assertArrayEquals(new Integer[]{null, null, null, null ,null, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null ,null, null, null}, AL.getArray());
        AL.printDeque();
    }

    /** get testovi */
    @Test
    public void getTestSet() {
        /* Test Set 1 */
        ArrayDeque<Integer> AL = new ArrayDeque<>();
        for (int i = -1; i > -8; i -= 1)
            AL.addFirst(i);
        for (int i = 0; i < 3; i += 1)
            AL.addLast(i);
        AL.printDeque();

        Integer[] IL = new Integer[]{-7, -6, -5, -4, -3, -2, -1, 0, 1, 2};
        for (int i = 0; i < 10; i += 1)
            assertEquals(AL.get(i), IL[i]);
    }

    /** Random testovi */
    @Test
    public void randomTestSet() {
        /* Test Set 1 */
        ArrayDeque<Integer> ALD = new ArrayDeque<>();
        ArrayList<Integer> AL = new ArrayList<>();
        for (int i = 0; i < 10000; i += 1) {
            int operacija = StdRandom.uniform(0, 3);
            int broj = StdRandom.uniform(1, 100);
            if (operacija == 0)
                assertEquals(AL.size(), ALD.size());
            else if (operacija == 1) {
                AL.add(0, broj);
                ALD.addFirst(broj);
            }
            else if (operacija == 2) {
                AL.add(broj);
                ALD.addLast(broj);
            }
        }
        out.println(AL.size());
        out.println(ALD.size());

        for (int i = 0; i < 10000; i += 1) {
            int operacija = StdRandom.uniform(0, 3);
            if (operacija == 0)
                assertEquals(AL.size(), ALD.size());
            else if (operacija == 1)
                assertEquals(AL.size() == 0 ? null : AL.remove(0), ALD.removeFirst());
            else if (operacija == 2)
                assertEquals(AL.size() == 0 ? null : AL.remove(AL.size() - 1), ALD.removeLast());
        }
    }

    /** Testira liste na jednakost. */
    @Test
    public void equalsTest() {
        ArrayDeque<Integer> A1 = new ArrayDeque<>();
        for (int i = 0; i < 3; A1.addFirst(i), i += 1);

        LinkedListDeque<Integer> L1 = new LinkedListDeque<>();
        for (int i = 0; i < 3; L1.addFirst(i), i += 1);

        ArrayDeque<Integer> A2 = new ArrayDeque<>();
        for (int i = 0; i < 3; A2.addFirst(i), i += 1);

        ArrayDeque<Integer> A3 = new ArrayDeque<>();
        for (int i = 3; i > 0; A3.addFirst(i), i -= 1);

        assertFalse(A1.equals(1));
        assertFalse(A1.equals("Lista"));
        assertFalse(A1.equals(L1));
        assertTrue(A1.equals(A2));
        assertFalse(A1.equals(A3));

        assertFalse(A1.simpleEquals(1));
        assertFalse(A1.simpleEquals("Lista"));
        assertFalse(A1.simpleEquals(L1));
        assertTrue(A1.simpleEquals(A2));
        assertFalse(A1.simpleEquals(A3));
    }
}
