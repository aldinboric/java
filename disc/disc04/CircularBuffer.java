package disc.disc04;

import org.junit.Test;

import static org.junit.Assert.*;
import static java.lang.System.arraycopy;

public class CircularBuffer {
    public static int[] overflow(int[] array, int i, int k) {
        int[] newArray = new int[array.length + 1];
        /*
        for (int j = 0; j < array.length; j += 1, i += 1) {
            if (i == array.length)
                i = 0;
            newArray[j] = array[i];
        }
        */
        arraycopy(array, i, newArray, 0, array.length - i);
        arraycopy(array, 0, newArray, array.length - i, i);
        newArray[newArray.length - 1] = k;
        return newArray;
    }

    @Test
    public void overflowTest() {
        int[] A = new int[]{2, 3, 4, 5, 6, 7, 0, 1};
        int[] R = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};

        assertArrayEquals(R, overflow(A, 6, 8));
    }
}
