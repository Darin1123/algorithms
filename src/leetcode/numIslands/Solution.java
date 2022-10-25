package leetcode.numIslands;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            i = cur[0];
            j = cur[1];

            if (grid[i][j] == '1' && !visited[i][j]) {
                visited[i][j] = true;
                if (i > 0) {
                    queue.add(new int[] {i - 1, j});
                }
                if (i < grid.length - 1) {
                    queue.add(new int[] {i + 1, j});
                }
                if (j > 0) {
                    queue.add(new int[] {i, j - 1});
                }
                if (j < grid[0].length - 1) {
                    queue.add(new int[] {i, j + 1});
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                new char[] {'1', '1', '1', '1', '0'},
                new char[] {'1', '1', '0', '1', '0'},
                new char[] {'1', '1', '0', '0', '0'},
                new char[] {'0', '0', '0', '0', '0'}
        };

        System.out.println(new Solution().numIslands(grid));
    }
}
