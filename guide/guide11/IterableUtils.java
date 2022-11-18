package guide.guide11;

import java.util.ArrayList;
import java.util.List;

public class IterableUtils {
    public static <T> List<T> toList(Iterable<T> iterable) {
        List<T> result = new ArrayList<>();
        for (T item : iterable) {
            if (item == null)
                throw new IllegalArgumentException();
            result.add(item);
        }
        return result;
    }
}
