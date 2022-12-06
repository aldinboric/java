package week6;

import java.util.Arrays;
import week6.Tree;

import static week2.Sort.selectionSort;
import static java.lang.System.arraycopy;
import static java.lang.System.out;

public class Search {
    public static int binarySearch(Integer[] arr, Integer n) {
        class HelperCl {
            int search(int start, int middle, int end) {
                if (start > end)
                    return -1;
                else if (arr[middle].equals(n))
                    return middle;
                else if (n.compareTo(arr[middle]) > 0)
                    return search(middle + 1, ((middle + 1) + end) / 2, end);
                return search(start, (start + (middle - 1)) / 2, middle - 1);
            }
        }
        return new HelperCl().search(0, (arr.length - 1) / 2, arr.length - 1);
    }

    public static int[] mergeSortArrays(int[] arr1, int[] arr2) {
        class HelperCl {
            int[] sort(int[] result, int arr1index, int arr2index, int resultIndex) {
                if (arr1index == arr1.length || arr2index == arr2.length) {
                    arraycopy(arr1, arr1index, result, resultIndex, arr1.length - arr1index);
                    arraycopy(arr2, arr2index, result, resultIndex, arr2.length - arr2index);
                    return result;
                } else if (arr1[arr1index] < arr2[arr2index]) {
                    result[resultIndex] = arr1[arr1index];
                    return sort(result, arr1index + 1, arr2index, resultIndex + 1);
                }
                result[resultIndex] = arr2[arr2index];
                return sort(result, arr1index, arr2index + 1, resultIndex + 1);
            }
        }
        return new HelperCl().sort(new int[arr1.length + arr2.length], 0, 0, 0);
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;
        int rightSize = arr.length % 2 == 0 ? arr.length / 2 : (arr.length / 2) + 1;
        int[] lefthalf = new int[arr.length / 2]; arraycopy(arr, 0, lefthalf, 0, arr.length / 2);
        int[] righthalf = new int[rightSize]; arraycopy(arr, arr.length / 2, righthalf, 0, rightSize);
        return mergeSortArrays(mergeSort(lefthalf), mergeSort(righthalf));
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1, 3, 5, 7, 9};
        Integer[] arr2 = new Integer[]{2, 4, 6, 8};

        for (int i = -1; i < 12; i += 1)
            out.println("i: " + i + ", found: " + binarySearch(arr1, i));

        out.println();

        for (int i = -1; i < 11; i += 1)
            out.println("i: " + i + ", found: " + binarySearch(arr2, i));

        out.println();

        out.println(Arrays.toString(mergeSortArrays(new int[]{2, 3, 6, 10, 11}, new int[]{4, 5, 7, 8})));

        out.println();

        out.println(Arrays.toString(mergeSort(new int[]{10, 2, 11, 6, 4, 3, 8, 7, 5})));

        Tree.makeTreeFromSortedArray(mergeSort(new int[]{10, 2, 11, 6, 4, 3, 8, 7, 5})).printTree();

    }
}
