package guerrilla.MT1;

import static java.lang.System.out;

public class Knapsack {
    public String thing;
    public double amount;

    public Knapsack(String str, double amount) {
        thing = str;
        this.amount = amount;
    }

    public Knapsack(String str) {
        this(str, 100.45);
    }

    public static void main(String[] args) {
        Knapsack sack = new Knapsack("Doge coin");
        out.println(sack.thing + " : " + sack.amount);
    }
}
