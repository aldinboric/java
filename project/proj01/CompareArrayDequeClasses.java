package project.proj01;

import java.util.Comparator;

public class CompareArrayDequeClasses {
     public static class Size<SType> implements Comparator<SType> {
         @Override
         public int compare(SType T1, SType T2) {
             if (T1 instanceof Integer)
                 return (Integer) T1 - (Integer) T2;
             else if (T1 instanceof String)
                 return ((String) T1).compareTo((String) T2);
             else
                 return -1;
        }
    }
}
