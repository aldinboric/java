package guerrilla.MT1;

import week2.IntList;

public class TryAnotherAngle {
    public static void triangularize(IntList[] R, IntList L) {
        for (int i = 0; i < L.size(); i += 1) {
            R[i] = L;
            for (int j = 0; j < i; j += 1, L = L.next);
            IntList tmp = L;
            L = L.next;
            tmp.next = null;
        }
    }

    public static void main(String[] args) {
        IntList L = IntList.of(1, 2, 3, 4, 5, 6, 7);
        IntList[] RL = new IntList[L.size()];
        triangularize(RL, L);
        for (IntList LI : RL)
            LI.print();
    }
}
