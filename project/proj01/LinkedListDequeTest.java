package project.proj01;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListDequeTest {
    /** Printa tablicu vremena izvršavanja metoda i kreiranja liste. */
    private static void izmjeriVrijeme(ArrayList<Integer> n, ArrayList<Double> t, ArrayList<Integer> opc) {
        System.out.printf("%12s %12s %12s %12s\n", "n", "vrijeme (s)", "# ops", "msec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < n.size(); i += 1) {
            int N = n.get(i);
            double time = t.get(i);
            int operationCount = opc.get(i);
            double timePerOperation = time / operationCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, operationCount, timePerOperation);
        }
    }

    /** Add testovi. */
    @Test
    public void addTestSet() {
        /* Test Set 1 */
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        for (int i = 3; i > 0; i -= 1)
            L.addFirst(i);
        L.addLast(4);
        for (int i = 0; i < 5; i += 1)
            L.removeLast();
        for (int i = 3; i < 6; i += 1)
            L.addLast(i);
        for (int i = 2; i > -1; i -= 1)
            L.addFirst(i);
        for (int i = 0; i < 6; i += 1)
            assertEquals(i, L.get(i).intValue());
        for (int i = 0; i < 6; i += 1)
            assertEquals(i, L.getRecursive(i).intValue());
        assertEquals("< 0 1 2 3 4 5 >", L.toString());
        // assertEquals("< 0 1 2 3 >", new LinkedListDeque<>(0, 1, 2, 3).printDeque());
        // assertEquals("< 0 1 2 3 >", list(0, 1, 2, 3).printDeque());
    }

    /** Random testovi. */
    @Test
    public void randomTestSet() {
        /* Test Set 1 */
        LinkedListDeque<Integer> LD = new LinkedListDeque<>();
        LinkedList<Integer> LL = new LinkedList<>();
        for (int i = 0; i < 3000; i += 1) {
            int operacija = StdRandom.uniform(0, 3);
            int broj = StdRandom.uniform(1, 100);
            if (operacija == 0)
                assertEquals(LL.size(), LD.size());
            else if (operacija == 1) {
                LD.addFirst(broj);
                LL.addFirst(broj);
            }
            else if (operacija == 2) {
                LD.addLast(broj);
                LL.addLast(broj);
            }
        }
        for (int i = 0; i < LL.size(); i += 1) {
            int operacija = StdRandom.uniform(0, 3);
            if (operacija == 0)
                assertEquals(LL.size(), LD.size());
            else if (operacija == 1)
                assertEquals(LL.removeFirst(), LD.removeFirst());
            else if (operacija == 2)
                assertEquals(LL.removeLast(), LD.removeLast());
        }

        /* Test Set 2 */
        LinkedListDeque<Integer> LD1 = new LinkedListDeque<>();
        ArrayDeque<Integer> AL = new ArrayDeque<>();
        for (int i = 0; i < 3000; i += 1) {
            int operacija = StdRandom.uniform(0, 3);
            int broj = StdRandom.uniform(1, 100);
            if (operacija == 0)
                assertEquals(AL.size(), LD1.size());
            else if (operacija == 1) {
                AL.addFirst(broj);
                LD1.addFirst(broj);
            }
            else if (operacija == 2) {
                AL.addLast(broj);
                LD1.addLast(broj);
            }
        }
        for (int i = 0; i < 3000; i += 1) {
            int operacija = StdRandom.uniform(0, 3);
            if (operacija == 0)
                assertEquals(AL.size(), LD1.size());
            else if (operacija == 1)
                assertEquals(AL.removeFirst(), LD1.removeFirst());
            else if (operacija == 2)
                assertEquals(AL.removeLast(), LD1.removeLast());
        }
    }

    /** LinkedListDeque testiranje vremena izvršavanja getLast() metode deset hiljada puta. */
    @Test
    public void testLinkedListDequeTime() {
        ArrayList<Integer> n = new ArrayList<>();
        ArrayList<Double> time = new ArrayList<>();
        ArrayList<Integer> ops = new ArrayList<>();
        for (int i = 1000; i <= 256000; i *= 2) {
            n.add(i);
            LinkedListDeque<Integer> tmpLinkedListDeque = new LinkedListDeque<>();
            for (int j = 0; j < i; j += 1) {
                tmpLinkedListDeque.addLast(j);
            }
            int op = 0;
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < i; j += 1) {
                tmpLinkedListDeque.get(j);
                op += 1;
            }
            time.add(sw.elapsedTime());
            ops.add(op);
        }
        izmjeriVrijeme(n, time, ops);
    }

    /** LinkedList testiranje vremena izvršavanja getLast() metode deset hiljada puta. */
    @Test
    public void testLinkedListTime() {
        ArrayList<Integer> n = new ArrayList<>();
        ArrayList<Double> time = new ArrayList<>();
        ArrayList<Integer> ops = new ArrayList<>();
        for (int i = 1000; i <= 256000; i *= 2) {
            n.add(i);
            LinkedList<Integer> tmpLinkedList = new LinkedList<>();
            for (int j = 0; j < i; j += 1) {
                tmpLinkedList.addLast(j);
            }
            int op = 0;
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < i; j += 1) {
                tmpLinkedList.get(j);
                op += 1;
            }
            time.add(sw.elapsedTime());
            ops.add(op);
        }
        izmjeriVrijeme(n, time, ops);
    }
}
