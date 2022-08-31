package leetcode.numSubmat;

class Solution {
    private int ans;
    private int m;
    private int n;
//    private boolean[][] visited;

    public int numSubmat(int[][] mat) {
        ans = 0;
        m = mat.length;
        n = mat.length;
//        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(mat, i, j, m, n);
            }
        }

        return ans;
    }

    private void dfs(int[][] mat, int i, int j, int v, int h) {
        if (i >= v || j >= h) {
            return;
        }

        if (mat[i][j] == 1) {
            System.out.println("(" + (i + 1) + ", " + (j + 1) + ")");
            ans++;
            // update boundaries
            if (i < m - 1 && mat[i + 1][j] == 0) {
                v = i + 1;
            }
            if (j < n - 1 && mat[i][j + 1] == 0) {
                h = j + 1;
            }

            dfs(mat, i + 1, j, v, h);
            dfs(mat, i, j + 1, v, h);
        }

    }

    public static void main(String[] args) {
//        int[][] mat = new int[][] {
//                new int[] {1, 0, 1},
//                new int[] {1, 1, 0},
//                new int[] {1, 1, 0}
//        };
        int[][] mat = new int[][] {
                new int[] {1, 1, 1},
                new int[] {1, 1, 1},
                new int[] {1, 1, 1}
        };
        System.out.println(new Solution().numSubmat(mat));
    }
}