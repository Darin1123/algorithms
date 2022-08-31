package leetcode.movingCount;

public class Solution {
    int[] memo;
    private int count;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        memo = new int[m + n];
        visited = new boolean[m][n];
        for (int i = 0; i < m + n; i++) {
            memo[i] = -1;
        }
        // brute force
        dfs(0, 0, m, n, k);

        return count;
    }

    private void dfs(int i, int j, int m, int n, int k) {
        if (visited[i][j]) {
            return;
        }

        int t = s(j) + s(i);
        visited[i][j] = true;
        if (t > k) {
            return;
        }

        count++;

        if (i < m - 1) {
            dfs(i + 1, j, m, n, k);
        }
        if (j < n - 1) {
            dfs(i, j + 1, m, n, k);
        }

    }

    private int s(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        int ans;
        if (n < 10) {
            ans = n;
        } else {
            ans =  n % 10 + s(n / 10);
        }

        memo[n] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int m = 38, n = 15, k = 9;
        System.out.println(new Solution().movingCount(m, n, k));
    }
}
