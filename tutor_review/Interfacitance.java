package tutor_review;

import static java.lang.System.out;

public class Interfacitance {
    public static class School {
        String name;
        int numStudents;

        public void cheer() {
            out.println("I have no idea what to say.");
        }

        public void enrollStudent() {
            numStudents += 1;
            if (numStudents % 1000 == 0) {
                out.println("We have " + numStudents + " students!");
            }
        }

        public void expelStudent() {
            numStudents -= 1;
        }
    }

    public static class University extends School {
        String motto;

        public University(String name, String motto) {
            super();
            this.name = name;
            this.motto = motto;
        }

        @Override
        public void cheer() {
            out.println(name + ' ' + motto);
        }

        @Override
        public void enrollStudent() {
            super.enrollStudent();
            out.println("Congratulations!");
        }
    }

    public static void main(String[] args) {
        School stanford = new University("Stanford", "Stanford is 2cool4school");
    }
}
