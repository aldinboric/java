package week4;

import week4.MapClass.Map;
import week4.MapClass.Map;

import java.util.Arrays;
import static java.lang.System.out;

public class LambdaMap {
    static int[] map(Map fn, int[] array) {
        for (int i = 0; i < array.length; i += 1)
            array[i] = fn.apply(array[i]);
        return array;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-1, -2, -3, -4, -5};
        // map(new Abs(), A);
        map(new Map() {public int apply(int x) {return Math.abs(x);}}, A);
        out.println(Arrays.toString(A));
    }
}
