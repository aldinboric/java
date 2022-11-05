package exam.prep03;

import org.junit.Test;
import week2.IntList;

import static org.junit.Assert.*;
import static java.lang.System.in;
import static week2.IntList.*;

import static java.lang.System.out;

public class Partition {
    public static IntList[] partition(IntList L, int k) {
        int size = L.size();
        int elementsPerArray = (size - (size % k)) / k;
        IntList[] result = new IntList[k];
        for (int i = 0, index = 0; i < k; i += 1) {
            if (i == k - 1)
                elementsPerArray = size - index;
            for (int j = 0; j < elementsPerArray; j += 1, index += 1) {
                if (result[i] == null)
                    result[i] = new IntList(L.get(index), null);
                else
                    insertRecursive(result[i], L.get(index), 0);
            }
            result[i] = reverseDestructiveIter(result[i]);
        }
        return result;
    }

    public static void printIntListArray(IntList[] arrayList) {
        for (IntList L : arrayList)
            L.print();
    }

    @Test
    public void testPartition() {
        IntList[] result = partition(IntList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25), 3);
        IntList[] correctResult = new IntList[]{IntList.of(25, 24, 23, 22, 21, 20, 19, 18, 17), IntList.of(16, 15, 14, 13, 12, 11, 10, 9), IntList.of(8, 7, 6, 5, 4, 3, 2, 1)};
        // printIntListArray(correctResult);
        printIntListArray(result);
    }
}
