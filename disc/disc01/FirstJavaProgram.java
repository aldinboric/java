package disc.disc01;

import static java.lang.System.out;

public class FirstJavaProgram {
    /** Iterativna verzija Fibonaci funkcije. */
    public static int fibIter(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i += 1) {
            int tmp = b;
            b = b + a;
            a = tmp;
        }
        return a;
    }

    /** Rekurzivna verzija Fibonaci funkcije. */
    public static int fibRec(int n ) {
        if (n <= 1)
            return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    /** Efektna rekurzivna verzija Fibonacci funkcije. */
    public static int fibRecEff(int n) {
        class helperCl {
            int helperFn(int n, int a, int b) {
                if (n == 0)
                    return a;
                return helperFn(n - 1, b, a + b);
            }
        }
        return new helperCl().helperFn(n, 0, 1);
    }

    public static void main(String[] args) {
        out.println(fibIter(5) + ", " + fibRec(5) + ", " + fibRecEff(5));
    }
}
