package week4;

public class MapClass {
    public interface Map {
        int apply(int x);
    }

    public interface MapInteger extends Map {

    }

    public static class Abs implements MapInteger {
        @Override
        public int apply(int x) {
            return Math.abs(x);
        }
    }
}
