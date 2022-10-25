package interview.sept0122.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int n = new Scanner(System.in).nextInt();
        int n = 100;
        int[] memo = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            System.out.println(i + ": " + f(memo, i));
        }
//        int res = f(memo, n);

//        System.out.println(res);
    }

    private static int f(int[] memo, int n) {
        if (memo[n] != 0) {
            return memo[n];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                int r = i + f(memo, n / i);
                if (r < res) {
                    res = r;
                }
            }
        }

        // prime number
        if (res == Integer.MAX_VALUE) {
            res = n;
        }

        memo[n] = res;

        return res;
    }


}
