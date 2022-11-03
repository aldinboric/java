package review;

import static java.lang.System.out;

public class TutorReview1 {
    public static void assignGrade(int grade) {
        if (grade < 60)
            out.println('F');
        else if (grade < 70)
            out.println('D');
        else if (grade < 80)
            out.println('C');
        else if (grade < 90)
            out.println('B');
        else
            out.println('A');
    }

    public static String twoSum(int[] nums, int target) {
        String result = "";
        for (int i = 0; i < nums.length; i += 1) {
            for (int j = 0; j < nums.length; j += 1) {
                if (nums[i] + nums[j] == target && j != i)
                    result += "(" + i + ":" + nums[i] + ", " + j + ":" + nums[j] + ")" + " ";
            }
        }
        return result;
    }

    public static int skiponacci(int n) {
        class HelperCl {
            int helperFn(int n, int a, int b, int c) {
                if (n == 0)
                    return a;
                return helperFn(n - 1, b, c, c + a);
            }
        }
        return new HelperCl().helperFn(n, 0, 1, 1);
    }

    public static class Journal {
        private int[] wages;
        private int[] hours;

        public Journal(int[] wages, int[] hours) {
            this.wages = wages;
            this.hours = hours;
        }

        public void addEntry(int wages, int hours) {

        }

        public int payCalc() {
            int total = 0;
            for (int i = 0; i < wages.length; i += 1) {
                total += hours[i] * wages[i];
            }
            return total;
        }
    }

    public static int addDigits(int n) {
        if (n < 10)
            return n;
        class helperCl {
            int addAll(int n, int result) {
                if (n == 0)
                    return result;
                return addAll(n / 10, result + n % 10);
            }
        }
        return addDigits(new helperCl().addAll(n, 0));
    }

    public static void main(String[] args) {
        /* assignGrade */
        for (int i = 55; i <= 95; i += 10)
            assignGrade(i);

        /* twoSum */
        out.println(twoSum(new int[]{1, 2, 3, 4, -5, -6, 7, -8, 9, 10}, 4));

        /* skiponacci */
        out.println(skiponacci(4));
        out.println(skiponacci(5));

        /* Journal */
        Journal j = new Journal(new int[]{4, 5, 3, 2, 8, 9}, new int[]{21, 23, 10, 12, 14, 6});
        out.println(j.payCalc() + "$");

        /* addDigits */
        out.println(addDigits(12349));
    }
}
