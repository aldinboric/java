package week4;

import java.util.function.Function;

import static java.lang.System.out;

public class HoF2 {
    public static double sqrt(double x) {
        return Math.sqrt(x);
    }

    public static double naTreću(Function<Double, Double> fn, double x) {
        return fn.apply(fn.apply(x));
    }

    public static void main(String[] args) {
        out.println(naTreću(HoF2::sqrt, 16));
    }
}
