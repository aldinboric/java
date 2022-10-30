package week1;

import static java.lang.System.out;
import static week1.Dog.dog;

public class largerThanFourNeighbors {
    /** Uspoređuje trenutnog psa sa četiri druga. */
    public static boolean compare(int index, Dog[] dogs, int left, int right) {
        for (int i = 0; i < left; i += 1) {
            if (dogs[(index - 1) - i].weight > dogs[index].weight)
                return false;
        }
        for (int i = 0; i < right; i += 1) {
            if (dogs[(index + 1) + i].weight > dogs[index].weight)
                return false;
        }
        return true;
    }

    /** Vraća niz sa psima koji su veći od četiri komšije. */
    public static Dog[] largerThanFourN(Dog[] dogs) {
        Dog[] result = new Dog[10];
        int n = 0;
        for (int i = 0; i < dogs.length; i += 1) {
            int left, right;
            if (i < 2) {
                left = i;
                right = 4 - i;
            } else if ((dogs.length - 1) - i < 2) {
                left = 4 - ((dogs.length - 1) - i);
                right = (dogs.length - 1) - i;
            } else
                left = right = 2;
            if (compare(i, dogs, left, right)) {
                result[n] = dogs[i];
                n += 1;
            }
        }
        return stripNulls(result, n);
    }

    /** Pravi novi niz bez null vrijednosti koje su višak. */
    public static Dog[] stripNulls(Dog[] dogs, int n) {
        Dog[] result = new Dog[n];
        for (int i = 0; i < n; i += 1)
            result[i] = dogs[i];
        return result;
    }

    /** Printa niz. */
    public static void printDogArray(Dog[] dogs) {
        for (Dog dog : dogs)
            out.print(dog.weight + ", ");
        out.println();
    }

    public static void main(String[] args) {
        /** largerThanFourN */
        Dog[] result1 = largerThanFourN(new Dog[]{dog(10), dog(15), dog(20), dog(15), dog(10), dog(5), dog(10), dog(15), dog(22), dog(20)});
        Dog[] result2 = largerThanFourN(new Dog[]{dog(10), dog(20), dog(30), dog(25), dog(20), dog(40), dog(10)});
        printDogArray(result1);
        printDogArray(result2);
    }
}
