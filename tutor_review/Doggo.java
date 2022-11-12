package tutor_review;

import static java.lang.System.out;

public class Doggo {
    public class Dog {
        String name;
        int age;
        int weight;

        public Dog() {
            this.name = "Doggo";
            this.age = 0;
            this.weight = 5;
        }

        public void bark() {
            out.println("bark");
        }
    }

    public class Husky extends Dog {
        String color;

        public Husky() {
            super();
            this.color = "white";
        }

        @Override
        public void bark() {
            for (int i = 0; i < this.weight % 10; i += 1)
                out.println("BARK");
        }

        public void updateAge(int age) {
            this.age = age;
        }
    }
}
