package disc.disc05;

import org.junit.Test;
import static org.junit.Assert.*;

public class Flatten {
    public static int[] flatten(int[][] input) {
        int len = 0;
        for (int i = 0; i < input.length; i += 1)
            len += input[i].length;
        int[] result = new int[len];
        for (int i = 0, k = 0; i < input.length; i += 1)
            for (int j = 0; j < input[i].length; j += 1, k += 1)
                result[k] = input[i][j];
        return result;
    }

    @Test
    public void flattenTest() {
        int[][] A = new int[][]{new int[]{1, 2, 3}, new int[]{}, new int[]{7, 8}};
        int[] R = new int[]{1, 2, 3, 7, 8};

        assertArrayEquals(R, flatten(A));
    }
}
