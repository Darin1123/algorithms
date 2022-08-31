package interview.aug2722.dj.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int n = new Scanner(System.in).nextInt();
//        System.out.println(countBeauty(n));

        for (int i = 6; i < 10; i++) {
            System.out.println(countBeauty(i));
        }
    }

    private static int countBeauty(int n) {
        if (n < 6) {
            return 0;
        }

        long[][] memo = new long[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    memo[i][j] = (long) Math.pow(26, j);
                }
                if (j == 0) {
                    memo[i][j] = 1;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                memo[i][j] = 3 * 26 * memo[i][j - 1] + memo[i - 1][j];
            }
        }

        long ans = 0;
        for (int i = 2; i <= n / 3; i++) {
            ans += memo[i][n - 3 * i];
        }

        return (int) (ans % (1000000000 + 7));
    }

    private static long f(long[][] memo, int n, int r) {
        if (r == 0) {
            return 1;
        }
        int lo = Math.min(n, r);
        int hi = Math.max(n, r);

        return memo[lo][hi];
    }
}
