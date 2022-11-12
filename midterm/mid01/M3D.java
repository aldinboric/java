package midterm.mid01;

import org.junit.Test;
import static org.junit.Assert.*;

public class M3D {
    public static int[][][] arraycopy3D(int[][][] array3D) {
        int[][][] result = new int[array3D.length][][];
        for (int i = 0; i < array3D.length; i += 1) {
            result[i] = new int[array3D[i].length][];
            for (int j = 0; j < array3D[i].length; j += 1) {
                result[i][j] = new int[array3D[i][j].length];
                for (int k = 0; k < array3D[i][j].length; k += 1)
                    result[i][j][k] = array3D[i][j][k];
            }
        }
        return result;
    }

    @Test
    public void arraycopy3DTest() {
        int[][][] A = new int[][][]{{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}, {{13, 14, 15}, {16, 17, 18}}};
        int[][][] R = arraycopy3D(A);
        assertArrayEquals(A, R);
    }
}
