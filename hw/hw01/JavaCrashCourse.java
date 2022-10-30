package hw.hw01;

import static java.lang.System.out;
import java.util.Arrays;

public class JavaCrashCourse {
    /** Printa trokut/piramidu. */
    public static void drawTriangle(int size) {
        for (int i = 1; i <= size; i += 1) {
            for (int j = size - i; j > 0; j -= 1)
                out.print(" ");
            for (int j = i * 2; j > 0; j -= 1)
                out.print("*");
            out.println();
        }
    }

    /** Vraća največu vrijednost niza. */
    public static int maxValue(int[] array) {
        if (array.length == 0)
            return 0;
        int maxVal = array[0];
        for (int i = 1; i < array.length; i += 1) {
            if (array[i] > maxVal)
                maxVal = array[i];
        }
        return maxVal;
    }

    /** Mijenja svaki array[i] sa sumom četiri naredna broja. */
    public static void windowPosSum(int[] array, int n) {
        for (int i = 0; i < array.length - 1; i += 1) {
            int sum = 0;
            if ((array.length - 1) - i < n)
                n -= 1;
            if (array[i] > 0) {
                for (int j = 0; j <= n; j += 1) {
                    sum += array[j + i];
                }
                array[i] = sum;
            }
        }
    }

    public static void main(String[] args) {
        /* drawTriangle */
        drawTriangle(5);

        /* maxValue */
        out.println(maxValue(new int[]{9, 2, 15, 2, 22, 10, 6}));

        /* windowPosSum */
        int[] arr = new int[]{1, 2, -3, 4, 5, 4};
        windowPosSum(arr, 3);
        out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{1, -1, -1, 10, 5, -1};
        windowPosSum(arr1, 2);
        out.println(Arrays.toString(arr1));
    }
}
