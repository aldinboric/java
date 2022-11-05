package disc.disc04;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayTransponse {
    public static void transponse(int[][] array) {
        for (int i = 0; i < array.length; i += 1) {
            for (int j = i + 1; j < array[0].length; j += 1) {
                int tmp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = tmp;
            }
        }
    }

    @Test
    public void transponseTest() {
        int[][] M = new int[][]{{1,   2,  3,  4},
                                {5,   6,  7,  8},
                                {9,  10, 11, 12},
                                {13, 14, 15, 16}};

        int[][] MR = new int[][]{{1, 5,  9, 13},
                                 {2, 6, 10, 14},
                                 {3, 7, 11, 15},
                                 {4, 8, 12, 16}};

        transponse(M);
        assertArrayEquals(MR, M);
    }
}
