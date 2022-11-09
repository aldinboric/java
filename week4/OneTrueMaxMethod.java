package week4;

import static java.lang.System.out;

public class OneTrueMaxMethod {
    public interface Comparable<T> {
        boolean compareTo(T another);
    }

    public static class Dog implements Comparable<Dog> {
        private int size;
        private String name;

        public Dog(int s, String str) {
            size = s;
            name = str;
        }

        @Override
        public boolean compareTo(Dog another) {
            if (size > another.size)
                return true;
            return false;
        }
    }

    public static class Cat implements Comparable<Cat> {
        private int size;
        private String name;

        public Cat(int s, String str) {
            size = s;
            name = str;
        }

        @Override
        public boolean compareTo(Cat another) {
            if (size > another.size)
                return true;
            return false;
        }
    }

    public static class Human implements Comparable<Human> {
        private int size;
        private String name;

        public Human(int s, String str) {
            size = s;
            name = str;
        }

        @Override
        public boolean compareTo(Human another) {
            if (size > another.size)
                return true;
            return false;
        }
    }

    public static Comparable largestObject(Comparable[] objectArray) {
        int maxIndex = 0;
        for (int i = 1; i < objectArray.length; i += 1)
            if (objectArray[i].compareTo(objectArray[maxIndex]))
                maxIndex = i;
        return objectArray[maxIndex];
    }

    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{new Dog(1, "A"), new Dog(2, "B"), new Dog(3, "C")};
        Cat[] cats = new Cat[]{new Cat(2, "B"), new Cat(3, "C"), new Cat(4, "D")};
        Human[] humans = new Human[]{new Human(3, "C"), new Human(4, "D"), new Human(5, "E")};
        out.println(((Dog) largestObject(dogs)).name);
        out.println(((Cat) largestObject(cats)).name);
        out.println(((Human) largestObject(humans)).name);
    }
}
