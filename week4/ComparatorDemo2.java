package week4;

import java.util.Comparator;

import static java.lang.System.out;

public class ComparatorDemo2 {
    public static class Dog {
        private int size;
        private String name;

        public Dog(int s, String str) {
            size = s;
            name = str;
        }

        private static class NameComparator implements Comparator<Dog> {
            public int compare(Dog a, Dog b) {
                return a.name.compareTo(b.name);
            }
        }

        private static class SizeComparator implements Comparator<Dog> {
            public int compare(Dog a, Dog b) {
                return a.size - b.size;
            }
        }
    }

    public static class Cat {
        private int size;
        private String name;

        public Cat(int s, String str) {
            size = s;
            name = str;
        }
    }

    public static class Human {
        private int size;
        private String name;

        public Human(int s, String str) {
            size = s;
            name = str;
        }
    }

    public static Object largestObject(Object[] objectArray, Comparator c) {
        int maxIndex = 0;
        for (int i = 1; i < objectArray.length; i += 1)
            if (c.compare(objectArray[i], objectArray[maxIndex]) > 0)
                maxIndex = i;
        return objectArray[maxIndex];
    }

    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{new Dog(3, "A"), new Dog(2, "B"), new Dog(1, "C")};
        Dog largestDog = (Dog) largestObject(dogs, new Dog.SizeComparator());
        out.println(largestDog.name);
    }
}
