package guide.guide06;

import guide.guide06.Arrrrghrays.Piece;

public class Sort {
    public static void swap(Piece[] array, int currentIndex, int smallestStrIndex) {
        Piece tmp = array[currentIndex];
        array[currentIndex] = array[smallestStrIndex];
        array[smallestStrIndex] = tmp;
    }

    /** Indeks najmanjeg dijela */
    public static int smallestPieceIndex(Piece[] array, int start) {
        int index = start;
        for (int i = start + 1; i < array.length; i += 1) {
            if (array[index].getLon() > array[i].getLon())
                index = i;
        }
        return index;
    }

    /** Selection Sort */
    public static Piece[] selectionSort(Piece[] array) {
        for (int i = 0; i < array.length - 1; i += 1) {
            int smallestStrIndex = smallestPieceIndex(array, i);
            swap(array, i, smallestStrIndex);
        }
        return array;
    }
}
