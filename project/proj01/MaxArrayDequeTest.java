package project.proj01;

import org.junit.Test;
import java.util.Comparator;

import static java.lang.System.out;
import static org.junit.Assert.*;
import static project.proj01.CompareArrayDequeClasses.*;

public class MaxArrayDequeTest {
    @Test
    public void testCompareBy() {
        Comparator<Integer> sizeComparator = new Size<>();
        MaxDeque<Integer> D1 = new MaxArrayDeque<>(sizeComparator);
        for (int i = 1; i < 15; D1.addLast(i), i += 1);
        D1.printDeque();
        out.println(D1.max());
    }
}
