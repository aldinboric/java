package guide.guide06;

import static org.junit.Assert.*;
import org.junit.Test;

public class HoFArrays {
    public static String checkForBiggestString(String[][] array2D, int x, int y) {
        String result = array2D[x][y] == null ? "" : array2D[x][y];
        for (int i = x - 1; i < x + 2; i += 1)
            for (int j = y - 1; j < y + 2; j += 1) {
                if (array2D[i][j] != null && array2D[i][j].length() > result.length())
                    result = array2D[i][j];
            }
        return result;
    }

    public static String[][] step(String[][] array2D) {
        String[][] result = new String[array2D.length][array2D[0].length];
        for (int i = 1; i < array2D.length - 1; i += 1)
            for (int j = 1; j < array2D[0].length - 1; j += 1) {
                String biggestString = checkForBiggestString(array2D, i, j);
                result[i][j] = biggestString;
            }
        return result;
    }

    @Test
    public void stepTest() {
        String[][] P = new String[][]{{null, null, null,  null,  null,   null},
                                      {null, "a",  "cat", "cat", "dogs", null},
                                      {null, "a",  null,  "cat", "a",    null},
                                      {null, "a",  "ca",  "",    "ca",   null},
                                      {null, null, null,  null,  null,   null}};

        String[][] R = new String[][]{{null, null,  null,  null,   null,   null},
                                      {null, "cat", "cat", "dogs", "dogs", null},
                                      {null, "cat", "cat", "dogs", "dogs", null},
                                      {null, "ca",  "cat", "cat",  "cat",  null},
                                      {null, null,  null,  null,   null,   null}};

        assertArrayEquals(R, step(P));
    }
}
