package guerrilla.MT1;

public class SomeSortOfInterface {
    public interface SortedList {
        int get(int i);
        int remove(int i);
        void insert(int elem);
        int size();

        default void merge(SortedList other) {
            for (int i = 0; i < other.size(); i += 1)
                this.insert(other.get(i));
        }

        default void negate() {
            for (int i = 0; i < this.size(); i += 1)
                this.insert(this.remove(i) - 1);
        }
    }
}
