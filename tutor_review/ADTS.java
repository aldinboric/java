package tutor_review;

public class ADTS {
    public interface SortedList {
        int get(int index);
        void sort();
        void merge(SortedList other);
    }
}
