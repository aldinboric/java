package week1;

import static java.lang.System.out;

public class PrimeNumbersHilfinger {
    /** GCD (najveći zajednički djeljitelj) */
    public static int gcd(int a, int b) {
        int result = 0;
        for (int i = 1; i < Math.min(a, b); i += 1) {
            if (a % i == 0 && b % i == 0)
                result = i;
        }
        return result;
    }

    /** Provjerava da li je broj prost. */
    public static boolean isPrime(int x) {
        if (gcd(x, x) == 1)
            return true;
        return false;
    }

    /** Printa sve proste brojeve od dva do n + 1. */
    public static void printPrimes(int n) {
        int j = 0;
        for (int i = 2; i < n + 1; i += 1) {
            if (isPrime(i)) {
                j += 1;
                out.print(i + " ");
                if (j % 10 == 0)
                    out.println();
            }
        }
        if (j % 10 != 0)
            out.println();
    }

    public static void main(String[] args) {
        /* printPrimes */
        printPrimes(101);
    }
}
