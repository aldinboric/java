package disc.disc04;

import static org.junit.Assert.*;
import org.junit.Test;

public class Rotate {
    private interface lambdafn {
        int apply(int x, int y);
    }

    private static final lambdafn modulo = (x, y) -> Math.abs(x % y);
    public static int[] rotate(int[] arr, int k) {
        int[] result = new int[arr.length];
        int startingPosition = modulo.apply(k, arr.length);
        for (int i = 0; i < arr.length; i += 1, startingPosition += 1) {
            if (startingPosition == arr.length)
                startingPosition = 0;
            result[i] = arr[startingPosition];
        }
        return result;
    }

    @Test
    public void testRotate() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        int[] res = new int[]{4, 5, 6, 7, 0, 1, 2, 3};

        assertArrayEquals(res, rotate(arr, -12));
    }
}
