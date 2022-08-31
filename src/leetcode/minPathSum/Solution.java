package leetcode.minPathSum;

/**
 * Problem url: https://leetcode.cn/problems/minimum-path-sum/
 * @author Zefeng Wang
 */

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] aux = new int[m][n];
        aux[m - 1][n - 1] = grid[m - 1][n - 1];

        // get last line
        for (int i = n - 2; i >= 0 ; i--) {
            aux[m - 1][i] = grid[m - 1][i] + aux[m - 1][i + 1];
        }

        // get the rest of lines
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    aux[i][j] = grid[i][j] + aux[i + 1][j];
                } else {
                    aux[i][j] = grid[i][j] + Math.min(aux[i + 1][j], aux[i][j + 1]);
                }
            }
        }

        return aux[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                new int[] { 1, 3 ,1, },
                new int[] { 1, 5, 1, },
                new int[] { 4, 2, 1, }
        };

        System.out.println(new Solution().minPathSum(grid));
    }
}
