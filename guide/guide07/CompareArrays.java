package guide.guide07;

import org.junit.Test;
import static org.junit.Assert.*;
import static java.lang.System.out;

public class CompareArrays {
    /** Uspoređuje dva niza koji mogu imati podnizove i sl. dok su ostali elementi brojevi tipa int. */
    public static boolean arrEquals(Object[] arr1, Object[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        class HelperCl {
            boolean helperFn(int index) {
                if (index == arr1.length)
                    return true;
                else if (arr1[index].getClass().isArray() || arr2[index].getClass().isArray()) {
                    if (arr1[index].getClass().isArray() && arr2[index].getClass().isArray())
                        return arrEquals((Object[]) arr1[index], (Object[]) arr2[index]) && helperFn(index + 1);
                    else
                        return false;
                }
                else if ((int) arr1[index] != (int) arr2[index])
                    return false;
                else
                    return helperFn(index + 1);
            }
        }
        return new HelperCl().helperFn(0);
    }

    @Test
    public void compareTest() {
        Object[] arr1 = new Object[]{1, 2, new Object[]{3, 4}, 5, 6, new Object[]{7, new Object[]{8, 9}}, 10};
        Object[] arr2 = new Object[]{1, 2, new Object[]{3, 4}, 5, 6, new Object[]{7, new Object[]{8, 9}}, 10};
        out.println(arrEquals(arr1, arr2));
        assertArrayEquals(arr1, arr2);
    }
}
