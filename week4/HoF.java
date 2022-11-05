package week4;

import static java.lang.System.out;

public class HoF {
    public interface cl {
        int add(int b);
    }

    public static cl adder(int a) {
        class adderHelperCl implements cl {
            public int add(int b) {
                return a + b;
            }
        }
        return new adderHelperCl();
    }

    public static void main(String[] args) {
        out.println(adder(1).add(2));
    }
}
