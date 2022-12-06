package lab.lab06;

import java.util.Arrays;

import static java.lang.System.out;

public class Duplicate {
    public static boolean hasDuplicate(int[] arr) {
        Arrays.sort(arr);
        int i = 0, j = 1;
        boolean duplicate = false;
        while (i < arr.length - 1 && j < arr.length) {
            if (!duplicate && arr[i] != arr[j])
                return false;
            else if (duplicate && arr[i] != arr[j]) {
                i = j;
                duplicate = false;
            } else
                duplicate = true;
            j += 1;
        }
        return duplicate;
    }

    public static void main(String[] args) {
        out.println(hasDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}));
    }
}
