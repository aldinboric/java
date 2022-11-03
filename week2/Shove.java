package week2;

import org.junit.Test;

import static java.lang.System.arraycopy;
import static org.junit.Assert.*;

/** @source <a href="https://inst.eecs.berkeley.edu/~cs61b/sp22/materials/lectures/lect6.pdf#section.10">Another problem</a> */
public class Shove {
    public static boolean checkIfLarger(int[] array, int index) {
        for (int i = index; i < array.length - 1; i += 1) {
            if (!(array[i] > array[array.length - 1]))
                return false;
        }
        return true;
    }
    public static int[] moveOver(int[] array) {
        int i = 0;
        for (; i < array.length - 1; i += 1) {
            if (checkIfLarger(array, i))
                break;
        }
        int tmp = array[array.length - 1];
        arraycopy(array, i, array, i + 1, (array.length - 1) - i);
        array[i] = tmp;
        return array;
    }

    @Test
    public void moveOverTest() {
        int[] lst1 = new int[]{1, 9, 4, 3, 0, 12, 11, 9, 15, 22, 12};
        int[] result1 = new int[]{1, 9, 4, 3, 0, 12, 11, 9, 12, 15, 22};
        assertArrayEquals(result1, moveOver(lst1));

        int[] lst2 = new int[]{1, 9, 4, 3, 0, 12, 11, 9, 15, 22, -2};
        int[] result2 = new int[]{-2, 1, 9, 4, 3, 0, 12, 11, 9, 15, 22};
        assertArrayEquals(result2, moveOver(lst2));

        int[] lst3 = new int[]{1, 9, 4, 3, 0, 12, 11, 9, 12, 15, 22};
        int[] result3 = new int[]{1, 9, 4, 3, 0, 12, 11, 9, 12, 15, 22};
        assertArrayEquals(result3, moveOver(lst3));
    }
}
