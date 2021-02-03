package interview.wawei.question1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * N kids are buying your candy. These kids lined up a queue and each of them will have one of $1,
 * $5, $10. Initially you have no money, after each purchase, you need to give the kid change. If
 * you can not give the kid the change, then return false. If all kids get their candies and
 * change, return true. Also print out the money before you return.
 */
public class Main {
    private final Map<Integer, Integer> cashing;

    public Main() {
        cashing = new HashMap<>();
        cashing.put(1, 0);
        cashing.put(5, 0);
        cashing.put(10, 0);
    }

    public int getCount(int denomination) {
        return this.cashing.get(denomination);
    }

    public void reduce(int denomination, int quantity) {
        int remaining = getCount(denomination);
        cashing.put(denomination, remaining - quantity);
    }

    public void increment(int denomination) {
        int remaining = getCount(denomination);
        cashing.put(denomination, ++remaining);
    }

    public boolean checkTransactions(String[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i].equals("10")) {
                if (getCount(5) > 0) {
                    if (getCount(1) < 4) {
                        return false;
                    }
                    this.reduce(5, 1);
                    this.reduce(1, 4);
                } else {
                    if (getCount(1) < 9) {
                        return false;
                    }
                    this.reduce(1, 9);
                }
                this.increment(10);
            } else if (in[i].equals("5")) {
                if (getCount(1)<4) {
                    return false;
                }
                this.reduce(1, 4);
                this.increment(5);
            } else {
                this.increment(1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String in = new Scanner(System.in).nextLine();
        String[] inArray = in.split(",");
        Main main = new Main();
        boolean canBeDone = main.checkTransactions(inArray);
        if (canBeDone) {
            System.out.print("TRUE:");
        } else {
            System.out.print("FALSE:");
        }
        System.out.printf(
                "[%d,%d,%d]%n",
                main.getCount(10),
                main.getCount(5),
                main.getCount(1));
    }
}
