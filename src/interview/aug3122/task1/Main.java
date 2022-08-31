package interview.aug3122.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = n;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int[] depths = new int[n + 1];
        depths[1] = 1;
        // construct depths
        dfs(depths, 1, n / 2 - 1, 2);
        dfs(depths, n / 2 + 1, n, 2);

        int t = n;
        for (Integer depth : depths) {
            if (depth != 0) {
                t -= depth;
                res += t;
            }
        }

        System.out.println(res);
    }

    private static void dfs(int[] depths, int lo, int hi, int depth) {
        if (lo > hi) {
            return;
        }

        depths[depth]++;
        int mid = lo + (hi - lo) / 2;
        dfs(depths, lo, mid - 1, depth + 1);
        dfs(depths, mid + 1, hi, depth + 1);
    }

}