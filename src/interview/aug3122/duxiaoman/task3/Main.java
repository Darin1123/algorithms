package interview.aug3122.duxiaoman.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if (n == 1) {
            System.out.println(9);
            return;
        }
        if (n == 2) {
            System.out.println(80);
            return;
        }
        long a = f(n - 2, 8,"1p");
        long b = f(n - 2, 8, "p1");
        long c = f(n - 2, 64, "pp");


        System.out.println((a + b + c) % 1000000007);
    }

    public static long f(int n, long value, String left) {
        if (n == 0) {
            return value;
        }

        if (left.equals("pp")) {
            return f(n - 1, 8 * value, "pp") + f(n - 1, value, "1p");
        }
        if (left.equals("p1")) {
            return f(n - 1, 8 * value, "pp");
        }
        // "1p"
        return f(n - 1,  8 * value, "p1");
    }
}
