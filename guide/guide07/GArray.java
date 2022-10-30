package guide.guide07;

import org.junit.Test;
import static java.lang.System.out;

/** Genericni niz koji moze da sadrzi podnizove i elemente tipa T.
  * Podnizovi takoder mogu da sadrze podnizove, elemente tipa T i slicno. */
public class GArray<T> {
    public boolean arrEquals(Object[] arr1, Object[] arr2) {
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
                else if ((T) arr1[index] != (T) arr2[index])
                    return false;
                else
                    return helperFn(index + 1);
            }
        }
        return new HelperCl().helperFn(0);
    }

    @Test
    public void testGArray() {
        GArray<Character> arrG = new GArray<>();
        Object[] arr1 = new Object[]{'a', 'b', new Object[]{'c', 'd'}, 'e', 'f', new Object[]{'g', new Object[]{'h', 'i'}}, 'j'};
        Object[] arr2 = new Object[]{'a', 'b', new Object[]{'c', 'd'}, 'e', 'f', new Object[]{'g', new Object[]{'h', 'i'}}, 'j'};
        out.println(arrG.arrEquals(arr1, arr2));
    }
}

