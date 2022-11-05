package guide.guide06;

import org.junit.Test;
import java.util.Arrays;

import static guide.guide06.Sort.*;
import static java.lang.System.out;
import static org.junit.Assert.*;
import static guide.guide06.Arrrrghrays.Piece.*;

public class Arrrrghrays {
    public static class Piece {
        private int longitude;
        private int latitute;

        private Piece(int x, int y) {
            longitude = x;
            latitute = y;
        }

        public static Piece P(int x, int y) {
            return new Piece(x, y);
        }

        public int getLon() {
            return longitude;
        }

        public int getLat() {
            return latitute;
        }
    }

    private static boolean checkIfContains(int[] result, int x) {
        for (int i : result)
            if (i == x)
                return true;
        return false;
    }

    private static int[] uniqueLatidudes(Piece[] array) {
        int[] result = new int[(int) Math.sqrt(array.length)];
        for (int i = 0, j = 0; i < array.length; i += 1)
            if (j == result.length)
                return result;
            else if (!checkIfContains(result, array[i].getLat())) {
                result[j] = array[i].getLat();
                j += 1;
            }
        return result;
    }

    private static Piece[][] groupByLat(Piece[][] result, Piece[] array) {
        int[] latitudes = uniqueLatidudes(array);
        for (int i = 0; i < result.length; i += 1) {
            int k = 0;
            for (int j = 0; j < array.length; j += 1)
                if (k == result.length)
                    break;
                else if (latitudes[i] == array[j].getLat()) {
                    result[i][k] = array[j];
                    k += 1;
                }
            sortByLon(result[i]);
        }
        return result;
    }

    private static void sortByLon(Piece[] array) {
        selectionSort(array);
    }

    private static Piece[][] sortByColumn(Piece[][] array2D) {
        return array2D;
    }

    public static Piece[][] solvePuzzle(Piece[] array) {
        int N = (int) Math.sqrt(array.length);
        Piece[][] result = new Piece[N][N];
        return sortByColumn(groupByLat(result, array));
    }

    @Test
    public void solvePuzzleTest() {
        Piece[] P = new Piece[]{P(0, 0), P(10, 10), P(20, 20), P(10, 0), P(20, 0), P(20, 10), P(0, 20), P(10, 20), P(0,10)};

        Piece[][] R = new Piece[][]{new Piece[]{P(0, 20), P(10, 20), P(20, 20)},
                                    new Piece[]{P(0, 10), P(10, 10), P(20, 10)},
                                    new Piece[]{P(0,  0), P(10,  0), P(20,  0)}};

        Piece[][] PR = solvePuzzle(P);

        /*
        for (int i = 0; i < 3; i += 1)
            assertArrayEquals(R[i], PR[i]);
        */

        for (Piece[] PA : PR) {
            for (Piece PI : PA)
                out.print("(" + PI.getLon() + ", " + PI.getLat() + ") ");
            out.println();
        }
    }
}
