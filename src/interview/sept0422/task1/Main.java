package interview.sept0422.task1;

import java.util.Scanner;

public class Main {
    private static int res = 0;
    private static int n = 0;
    private static int m = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            dfs(board, 0, i, 0);
        }

        System.out.println(res);
    }

    private static void dfs(int[][] board, int i, int j, int score) {
        if (j < 0 || j > m - 1) {
            return;
        }
        if (i == n - 1) {
            res = Math.max(res, score + (board[i][j] == -1 ? 0 : board[i][j]));
            return;
        }
        if (board[i][j] == -1) {
            dfs(board, i + 1, j - 1, score);
            dfs(board, i + 1, j + 1, score);
        } else {
            dfs(board, i + 1, j, score + board[i][j]);
        }
    }
}
