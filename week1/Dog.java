package week1;

import static java.lang.System.out;

public class Dog {
    public int weight;

    public Dog() {}
    public Dog(int w) {
        weight = w;
    }

    public static Dog dog(int w) {
        return new Dog(w);
    }

    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weight > d2.weight)
            return d1;
        return d2;
    }

    public void makeNoise() {
        if (weight < 10)
            out.println("yip.");
        else if (weight < 30)
            out.println("bark!");
        else
            out.println("woof!");
    }
}
