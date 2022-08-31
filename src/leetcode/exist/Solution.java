package leetcode.exist;

/**
 *
 * @author Zefeng Wang
 */

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        boolean[][] taken = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, taken, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] taken, int i, int j, int c) {
        if (taken[i][j]) {
            return false;
        }

        taken[i][j] = true;

        if (board[i][j] == word.charAt(c)) {
            if (c == word.length() - 1) {
                return true;
            }

            // boundary handling and dfs

            // go up
            if (i > 0) {
                if (dfs(board, word, taken, i - 1, j, c + 1)) {
                    return true;
                }
            }

            // go down
            if (i < board.length - 1) {
                if (dfs(board, word, taken, i + 1, j, c + 1)) {
                    return true;
                }
            }

            // go left
            if (j > 0) {
                if (dfs(board, word, taken, i , j - 1, c + 1)) {
                    return true;
                }
            }

            // go right
            if (j < board[0].length - 1) {
                if (dfs(board, word, taken, i, j + 1, c + 1)) {
                    return true;
                }
            }
        }

        taken[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                new char[] {'A', 'B', 'C', 'E'},
                new char[] {'S', 'F', 'C', 'S'},
                new char[] {'A', 'D', 'E', 'E'},

        };

        System.out.println(new Solution().exist(board, "ABCCED"));
    }
}
