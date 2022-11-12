package midterm.mid01;

import static java.lang.System.out;

public class FibArray {
    public static int[][] makeFibArray(int n) {
        class HelperCl {
            int[][] helperFn(int m, int[][] result) {
                if (m == n)
                    return result;
                result[m] = fibArray(m);
                return helperFn(m + 1, result);
            }
        }
        return new HelperCl().helperFn(0, new int[n][]);
    }

    public static int[] fibArray(int n) {
        class HelperCl {
            int[] helperFn(int a, int b, int m, int[] result) {
                if (m > n)
                    return result;
                result[m] = a;
                return helperFn(b, a + b, m + 1, result);
            }
        }
        return new HelperCl().helperFn(0, 1, 0, new int[n + 1]);
    }

    public static void printFibArray(int[][] array2D) {
        for (int[] array : array2D) {
            for (int x : array)
                out.print(x + " ");
            out.println();
        }
    }

    public static void main(String[] args) {
        int[][] F = makeFibArray(10);
        printFibArray(F);
    }
}
