package guerrilla.MT1;

public class DavidHasselHoF {
    public static interface BinaryFunction {
        public int apply(int x, int y);
    }

    public static interface UnaryFunction {
        public int apply(int x);
    }

    public static class Adder implements BinaryFunction {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    }

    public static class Add10 implements UnaryFunction {
        @Override
        public int apply(int x) {
            return x + 10;
        }
    }

    public static class Multiplier implements BinaryFunction {
        public int apply(int x, int y) {
            return new Adder().apply(x, y);
        }
    }
}
