package exam.prep03;

import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.*;

public class FillGrid {
    public static int[][] fillGrid(int[][] grid, int[] LR, int[] UR) {
        if (LR.length < grid.length || UR.length < grid.length)
            return null;
        int k1, k2;
        k1 = k2 = 0;
        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < i; j += 1, k1 += 1) {
                grid[i][j] = LR[k1];
            }
            for (int j = i + 1; j < grid[0].length; j += 1, k2 += 1) {
                grid[i][j] = UR[k2];
            }
        }
        return grid;
    }

    public static void printGrid(int[][] grid) {
        for (int[] arr : grid) {
            for (int x : arr)
                out.print(x + " ");
            out.println();
        }
    }

    @Test
    public void testFillGrid() {
        int[] LL = {1,   2,  3,  4,  5,  6,  7,  8,  9, 10, 0, 0};
        int[] UR = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        int[][] S = {{0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0}};

        int[][] R = {{0, 11, 12, 13, 14},
                     {1,  0, 15, 16, 17},
                     {2,  3,  0, 18, 19},
                     {4,  5,  6,  0, 20},
                     {7,  8,  9, 10,  0}};

        assertArrayEquals(R, fillGrid(S, LL, UR));
        printGrid(S);
    }
}
