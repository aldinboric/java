package week4;

import java.util.Comparator;
import static java.lang.System.out;

public class ComparatorDemo {
    public interface Comparable<T> {
        int compareByName(T o);
        int compareBySize(T o);
    }

    public static class Dog implements Comparable<Dog> {
        private int size;
        private String name;

        public Dog(int s, String str) {
            size = s;
            name = str;
        }

        public int compareByName(Dog o) {
            class CompareHelper implements Comparator<Dog> {
                public int compare(Dog a, Dog b) {
                    return a.name.compareTo(b.name);
                }
            }
            return new CompareHelper().compare(this, o);
        }

        public int compareBySize(Dog o) {
            class CompareHelper implements Comparator<Dog> {
                public int compare(Dog a, Dog b) {
                    return a.size - b.size;
                }
            }
            return new CompareHelper().compare(this, o);
        }
    }

    public static class Cat implements Comparable<Cat> {
        private int size;
        private String name;

        public Cat(int s, String str) {
            size = s;
            name = str;
        }

        public int compareByName(Cat o) {
            class CompareHelper implements Comparator<Cat> {
                public int compare(Cat a, Cat b) {
                    return a.name.compareTo(b.name);
                }
            }
            return new CompareHelper().compare(this, o);
        }

        public int compareBySize(Cat o) {
            class CompareHelper implements Comparator<Cat> {
                public int compare(Cat a, Cat b) {
                    return a.size - b.size;
                }
            }
            return new CompareHelper().compare(this, o);
        }
    }

    public static class Human implements Comparable<Human> {
        private int size;
        private String name;

        public Human(int s, String str) {
            size = s;
            name = str;
        }

        public int compareByName(Human o) {
            class CompareHelper implements Comparator<Human> {
                public int compare(Human a, Human b) {
                    return a.name.compareTo(b.name);
                }
            }
            return new CompareHelper().compare(this, o);
        }

        public int compareBySize(Human o) {
            class CompareHelper implements Comparator<Human> {
                public int compare(Human a, Human b) {
                    return a.size - b.size;
                }
            }
            return new CompareHelper().compare(this, o);
        }
    }

    public static Comparable largestObject(Comparable[] objectArray) {
        int maxIndex = 0;
        for (int i = 1; i < objectArray.length; i += 1)
            if (objectArray[i].compareBySize(objectArray[maxIndex]) > 0)
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
