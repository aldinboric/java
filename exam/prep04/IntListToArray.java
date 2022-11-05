package exam.prep04;

import week2.IntList;
import org.junit.Test;

import static week2.IntList.*;
import static org.junit.Assert.*;

public class IntListToArray {
    public static int[] arrayCopyFromIntList(IntList List, int indexListstart, int[] array, int indexArrayStart, int numberOfitems) {
        if (numberOfitems > array.length || numberOfitems < 0)
            return array;
        else if (indexArrayStart > array.length || indexArrayStart < 0)
            return array;
        IntList ptr = List;
        for(int i = 0; i < indexListstart; i += 1) {
            if (ptr != null)
                ptr = ptr.next;
            else
                return array;
        }
        for (; numberOfitems > 0; numberOfitems -= 1, indexArrayStart += 1, ptr = ptr.next)
            array[indexArrayStart] = ptr.item;
        return array;
    }

    @Test
    public void arrayCopyFromIntListTest() {
        IntList L = of(1, 2, 3, 4, 5);
        int[] R = new int[]{2, 3, 4};

        int[] A = new int[3];
        assertArrayEquals(R, arrayCopyFromIntList(L, 1, A, 0, 3));
    }
}
