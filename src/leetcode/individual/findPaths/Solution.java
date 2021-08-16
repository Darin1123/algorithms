package leetcode.individual.findPaths;

/**
 * https://leetcode-cn.com/problems/out-of-boundary-paths/
 * @author Zefeng Wang
 */

public class Solution {
    private long res = 0;
    private long oldRes = 0;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dfs(m, n, maxMove, startRow, startColumn);
        return (int) (res % (Math.pow(10, 9) + 7));
    }

    private void dfs(int m, int n, int moves, int r, int c) {
        if ((r < 0 || r >= m) || (c < 0 || c >= n)) {
            res++;
            if (res - oldRes > 100000000) {
                System.out.println(res);
                oldRes = res;
            }
            return;
        }

        if (moves == 0) {
            return;
        }

        // move up
        dfs(m, n, moves - 1, r - 1, c);
        // move down
        dfs(m, n, moves - 1, r + 1, c);
        // move left
        dfs(m, n, moves - 1, r, c - 1);
        // move right
        dfs(m, n, moves - 1, r, c + 1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution().findPaths(8, 50, 23, 5, 26));
        System.out.println(System.currentTimeMillis() - start);
    }
}
