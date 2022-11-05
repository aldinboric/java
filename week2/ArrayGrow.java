package week2;

import static java.lang.System.arraycopy;
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayGrow {
    public static String[] insertArrayGrow(String[] array, int index, String item) {
        String[] newArray = new String[array.length + 1];
        arraycopy(array, 0, newArray, 0, index);
        arraycopy(array, index, newArray, index + 1, array.length - index);
        newArray[index] = item;
        return newArray;
    }

    @Test
    public void insertArrayGrowTest() {
        String[] A = new String[]{"bear", "gazelle", "hartebeest", "skunk", "monk", "kink"};
        String[] B = new String[]{"bear", "gazelle", "gnu", "hartebeest", "skunk", "monk", "kink"};
        assertArrayEquals(B, insertArrayGrow(A, 2, "gnu"));
    }
}
