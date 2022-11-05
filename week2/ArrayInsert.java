package week2;

import static java.lang.System.arraycopy;
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayInsert {
    public static String[] insert(String[] array, int index, String item) {
        /*
        String current = array[index];
        for (int i = index + 1; i < array.length; i += 1) {
            String tmp = array[i];
            array[i] = current;
            current = tmp;
        }
        */
        arraycopy(array, index, array, index + 1, array.length - (index + 1));
        array[index] = item;
        return array;
    }

    @Test
    public void testInsert() {
        String[] A = new String[]{"bear", "gazelle", "hartebeest", "skunk", "monk", "kink"};
        String[] B = new String[]{"bear", "gazelle", "gnu", "hartebeest", "skunk", "monk"};
        insert(A, 2, "gnu");
        assertArrayEquals(B, A);
    }
}
