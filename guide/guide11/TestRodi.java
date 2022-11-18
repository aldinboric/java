package guide.guide11;

import static java.lang.System.out;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRodi {
    @Test
    public void testRODI() {
        ReverseOddDigitIterator rodi = new ReverseOddDigitIterator(12345770);
        List<Integer> LResult = IterableUtils.toList(rodi);
        List<Integer> R = List.of(1, 3, 5, 7, 7);
        assertEquals(R, LResult);
    }
}
