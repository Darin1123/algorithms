package interview.aug1022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree {
    private int res = 0;
    private int[] colors;
    private boolean[] visited;

    private void dfs(List<List<Integer>> data, int cur, int val) {
        // 已被访问
        if (visited[cur - 1]) {
            return;
        }

        visited[cur - 1] = true;
        if (cur == 1) {
            res += 1;
            val = 1;
        } else {
            res += Math.abs(colors[cur - 1] + val);
            val += colors[cur - 1];
        }
        for (int i : data.get(cur - 1)) {
            dfs(data, i, val);
        }
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        String s = scanner.next();
//        int[][] array = new int[4][2];
//        for (int i = 0; i < 4; i++) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            array[i] = new int[] {a, b};
//        }

//        int n = 5;
//        String s = "RBRBB";
//        int[][] array = new int[][] {
//                new int[] {2, 5},
//                new int[] {1, 5},
//                new int[] {4, 1},
//                new int[] {3, 5}
//        };

        int n = 5;
        String s = "RRBRR";
        int[][] array = new int[][] {
                new int[] {1, 2},
                new int[] {1, 3},
                new int[] {1, 4},
                new int[] {4, 5},
        };

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] colors = new int[n];
        char rootColor = s.charAt(0);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == rootColor) {
                colors[i] = 1;
            } else {
                colors[i] = -1;
            }
        }

        List<List<Integer>> treeData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            treeData.add(new ArrayList<>());
        }


        for (int[] pair : array) {
            int a = pair[0];
            int b = pair[1];
            treeData.get(a - 1).add(b);
            treeData.get(b - 1).add(a);
        }


        Tree tree = new Tree();
        tree.colors = colors;
        tree.visited = new boolean[n];
        // 计算
        tree.dfs(treeData, 1, 0);

        System.out.println(tree.res);
    }
}
