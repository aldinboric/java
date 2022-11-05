package disc.disc04;

import java.util.Arrays;
import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.assertArrayEquals;

public class ArrayReverse {
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i += 1) {
            int tmp = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = tmp;
        }
    }

    public static void reverseDiagonalAll(int[][] matrix) {
        for (int i = 0; i < matrix.length * 2 - 1; i += 1)
            reverseDiagonal(matrix, i);
    }

    public static void reverseDiagonal(int[][] matrix, int n) {
        if (n >= (matrix.length * 2) - 1 || n < 0)
            return;
        else if (n < matrix.length)
            reverseHelper(matrix, n, 0, n);
        else
            reverseHelper(matrix, matrix.length - 1, n - (matrix.length - 1), (n - (n - matrix.length)) + 1);
    }

    private static void reverseHelper(int[][] matrix, int startRow, int startColumn, int n) {
        for (int i = startRow, j = startColumn; i > n / 2; i -= 1, j += 1) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = tmp;
        }
    }

    @Test
    public void reverseAndReverseDiagonalAllTest() {
        /*
        int[] A = new int[]{1, 2, 3, 4};
        int[] B = new int[]{1, 2, 3, 4, 5};

        reverse(A);
        reverse(B);

        out.println(Arrays.toString(A));
        out.println(Arrays.toString(B));
        */

        int[][] M = new int[][]{{1,   2,  3,  4},
                                {5,   6,  7,  8},
                                {9,  10, 11, 12},
                                {13, 14, 15, 16}};

        int[][] MR = new int[][]{{1, 5,  9, 13},
                                 {2, 6, 10, 14},
                                 {3, 7, 11, 15},
                                 {4, 8, 12, 16}};

        // reverseDiagonal(M, 2);
        reverseDiagonalAll(M);
        assertArrayEquals(MR, M);
    }
}
