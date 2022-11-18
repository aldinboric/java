package disc.disc04;

import static java.lang.System.out;

public class CatBusTask {
    interface Vehicle {
        void revEngine();
    }

    interface Honker {
        default void honk() {
            out.println("HONQUE!");
        }
    }

    public static class CatBus implements Vehicle, Honker {
        @Override
        public void revEngine() {
            out.println("Purrrrrrrr");
        }

        @Override
        public void honk() {
            out.println("CatBus says HONK");
        }

        public void conversation(Honker target) {
            honk();
            target.honk();
        }
    }

    public static class Plane implements Vehicle {
        @Override
        public void revEngine() {
            out.println("Haha engines go brrr");
        }

        public void honk() {
            out.println("Getting ready for takeoff!");
        }
    }

    public static class Goose implements Honker {
        public void pester(Vehicle victim) {
            out.println("BEP!");
        }

        public void pester(Plane p) {
            out.println("SQUAWK!");
        }
    }
}
