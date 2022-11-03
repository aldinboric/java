package guide.guide05;

import static java.lang.System.out;

public class PascalsTriangle {
    /** Konstruiše Paskalov trokut uz pomoć nizova. */
    public static int[][] getPascalsTriangle(int n) {
        int[][] result = new int[n][];
        result[0] = new int[]{1};
        for (int i = 1; i < n; i += 1) {
            result[i] = new int[i + 1];
            result[i][0] = 1;
            for (int j = 0; j < result[i].length - 2; j += 1) {
                result[i][j + 1] = result[i - 1][j] + result[i - 1][j + 1];
            }
            result[i][result[i].length - 1] = 1;
        }
        return result;
    }

    /** Printa Paskalov trokut. */
    public static void printPascalsTriangle(int[][] pascalsTriangle) {
        for (int i = 0; i < pascalsTriangle.length; i += 1) {
            for (int j = 0; j < pascalsTriangle.length - pascalsTriangle[i].length; j += 1)
                out.print(" ");
            for (int k = 0; k < pascalsTriangle[i].length; k += 1)
                out.print(pascalsTriangle[i][k] + " ");
            out.println();
        }
    }

    public static void main(String[] args) {
        printPascalsTriangle(getPascalsTriangle(6));
    }
}

