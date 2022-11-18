package guerrilla.MT1;

import org.junit.Test;
import static org.junit.Assert.*;

public class Rotate {
    public static int[][] rotate(int[][] arr) {
        int len = arr.length;
        int[][] result = new int[len][len];
        for (int i = 0; i < len; i += 1)
            for (int j = len - 1; j > -1; j -= 1)
                result[i][(len - 1) - j] = arr[j][i];
        return result;
    }

    @Test
    public void testRotate() {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] R = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};

        assertArrayEquals(R, rotate(A));
    }
}
