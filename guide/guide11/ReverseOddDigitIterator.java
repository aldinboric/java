package guide.guide11;

import java.util.Iterator;

public class ReverseOddDigitIterator implements Iterable<Integer> {
    private int _number;

    public ReverseOddDigitIterator(int number) {
        _number = reverse(keepOdd(number));
    }

    private static int keepOdd(int n) {
        int result = 0;
        for (int i = n, exp = 0; i > 0; i /= 10) {
            int tmp = i % 10;
            if (tmp % 2 == 1) {
                result += tmp * Math.pow(10, exp);
                exp += 1;
            }
        }
        return result;
    }

    private int reverse(int n) {
        int result = 0;
        int numberOfDigits = ((int) String.valueOf(n).length()) - 1;
        for (int i = n; i > 0; i /= 10, numberOfDigits -= 1)
            result += (i % 10) * Math.pow(10, numberOfDigits);
        return result;
    }

    private class OddDigitIterator implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            if (_number == 0)
                return false;
            return true;
        }

        @Override
        public Integer next() {
            int tmp = _number % 10;
            _number /= 10;
            return tmp;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new OddDigitIterator();
    }
}
