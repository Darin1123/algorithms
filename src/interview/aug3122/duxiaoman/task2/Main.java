package interview.aug3122.duxiaoman.task2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int z = sc.nextInt();
        for (int i = 0; i < z; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            if (x % k != 0) {
                System.out.println("no");
                return;
            }
            int[][] a = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    a[j][l] = sc.nextInt();
                }
            }
//            System.out.println(Arrays.deepToString(a));
            check(a, n, m, x);
        }
    }

    private static void check(int[][] a, int n, int m, int x) {
        if (dfs(a, n, m, 0, 0, x)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

    private static boolean dfs(int[][] a, int n, int m, int i, int j, int x) {
        x -= a[i][j];
        if (i == n - 1 && j == m - 1) {
            if (x == 0) {
                return true;
            }
        }
        if (i < n - 1) {
            if (dfs(a, n, m, i + 1, j, x)) {
                return true;
            }
        }

        if (j < m - 1) {
            if (dfs(a, n, m, i, j +  1, x)) {
                return true;
            }
        }

        return false;
    }
}
