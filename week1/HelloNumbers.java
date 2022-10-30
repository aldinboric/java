package week1;

import static java.lang.System.out;

public class HelloNumbers {
    /** Printa komulativnu sumu brojeva od nula do n.
      * @source "<a href="https://joshhug.gitbooks.io/hug61b/content/chap1/chap11.html">Exercise 1.1.2</a>" */
    public static void comulativeSum(int n) {
        for (int i = 0; i < n; i += 1) {
            out.print((i * (i + 1) / 2) + " ");
        }
        out.println();
    }

    public static void main(String[] args) {
        comulativeSum(10);
    }
}
