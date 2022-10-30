package week2;

import org.junit.Test;
import static org.junit.Assert.*;

public class Sort {
    public static void swap(String[] input, int currentIndex, int smallestStrIndex) {
        String tmp = input[currentIndex];
        input[currentIndex] = input[smallestStrIndex];
        input[smallestStrIndex] = tmp;
    }

    /** Indeks najmanjeg stringa */
    public static int smallestStringIndex(String[] input, int start) {
        int index = start;
        for (int i = start + 1; i < input.length; i += 1) {
            if (input[index].compareTo(input[i]) > 0)
                index = i;
        }
        return index;
    }

    /** Selection Sort */
    public static String[] selectionSort(String[] input) {
        for (int i = 0; i < input.length - 1; i += 1) {
            int smallestStrIndex = smallestStringIndex(input, i);
            swap(input, i, smallestStrIndex);
        }
        return input;
    }

    /** Indeks najmanjeg stringa (Rekurzivno) */
    public static int smallestStringIndexRecursive(String[] input, int start) {
        class helperCl {
            int helperFn(String[] input, int start, int smallestStrIndex) {
                if (start == input.length)
                    return smallestStrIndex;
                smallestStrIndex = input[smallestStrIndex].compareTo(input[start]) > 0 ? start : smallestStrIndex;
                return helperFn(input, start + 1, smallestStrIndex);
            }
        }
        return new helperCl().helperFn(input, start + 1, start);
    }

    /** Selection Sort (Rekurzivno) */
    public static String[] selectionSortRecursive(String[] input) {
        class helperCl {
            String[] helperFn(String[] input, int index) {
                if (index == input.length - 1)
                    return input;
                int smallestStrIndex = smallestStringIndexRecursive(input, index);
                swap(input, index, smallestStrIndex);
                return helperFn(input, index + 1);
            }
        }
        return new helperCl().helperFn(input, 0);
    }

    /** Test Sort. */
    @Test
    public void sortTest() {
        String[] input = new String[]{"he", "is", "the", "agoyatis", "of", "mr.", "conchis"};
        String[] sortedInput = new String[]{"agoyatis", "conchis", "he", "is", "mr.", "of", "the"};
        assertArrayEquals(sortedInput, selectionSortRecursive(input));

        String[] input1 = new String[]{"cows", "dwell", "above", "clouds"};
        String[] sortedInput1 = new String[]{"above", "clouds", "cows", "dwell"};
        assertArrayEquals(sortedInput1, selectionSortRecursive(input1));
    }
}
