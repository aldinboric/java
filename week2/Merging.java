package week2;

import static org.junit.Assert.*;
import org.junit.Test;

public class Merging {
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        class helperCl {
            static int[] helperFn(int[] result, int resultIndex, int[] arr1, int arr1index, int[] arr2, int arr2index) {
                if (resultIndex == result.length)
                    return result;
                else if (arr1.length == arr1index) {
                    result[resultIndex] = arr2[arr2index];
                    return helperFn(result, resultIndex + 1, arr1, arr1index, arr2, arr2index + 1);
                } else if (arr2.length == arr2index) {
                    result[resultIndex] = arr1[arr1index];
                    return helperFn(result, resultIndex + 1, arr1, arr1index + 1, arr2, arr2index);
                } else if (arr1[arr1index] < arr2[arr2index]) {
                    result[resultIndex] = arr1[arr1index];
                    return helperFn(result, resultIndex + 1, arr1, arr1index + 1, arr2, arr2index);
                } else {
                    result[resultIndex] = arr2[arr2index];
                    return helperFn(result, resultIndex + 1, arr1, arr1index, arr2, arr2index + 1);
                }
            }
        }
        return helperCl.helperFn(result, 0, arr1, 0, arr2, 0);
    }

    @Test
    public void mergeTest() {
        int[] A = new int[]{0, 2, 3, 6, 9, 11};
        int[] B = new int[]{1, 4, 5, 7, 8};

        int[] C = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        assertArrayEquals(C, merge(A, B));
    }
}
