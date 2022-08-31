package interview.aug2022;

import java.util.*;


class Point {
   int x;
   int y;
   public Point(int x, int y) {
     this.x = x;
     this.y = y;
   }

    @Override
    public String toString() {
        return "Point{" +
                 x +
                ", " + y +
                '}';
    }
}


public class Question3 {

    private boolean[][] visited = new boolean[4][4];
    private ArrayList<Point> ans = new ArrayList<>();
    private int minLength = 0;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param maze int整型二维数组 迷宫数据 固定为4x4的二维数组，0表示路，可走；1 表示墙，不可通过； 8 表示礼物，是我们的目标
     * @return Point类ArrayList
     */
    public ArrayList<Point> winMazeGift (int[][] maze) {
        // write code here

        // 找到奖品的地址 O(n * m)
        int px = 0, py = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (maze[i][j] == 8) {
                    px = i;
                    py = j;
                    break;
                }
            }
        }

        if (px == 0 || px == 3) {
            Point p = new Point(px, py);
            ArrayList<Point> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        if (py == 0 || py == 3) {
            Point p = new Point(px, py);
            ArrayList<Point> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        // 标记已经奖品位置为已经走过并加入路径
        visited[px][py] = true;

        ArrayList<Point> t = new ArrayList<>();
        t.add(new Point(px, py));

        // 深度优先搜索 
        // 遍历四周
        //向上
        if (px > 0) {
            dfs(maze, px - 1, py, t);
        }

        //向下
        if (px < 3) {
            dfs(maze, px + 1, py, t);
        }

        //向左
        if (py > 0) {
            dfs(maze, px, py - 1, t);
        }

        //向右
        if (py < 3) {
            dfs(maze, px, py + 1, t);
        }

        ArrayList<Point> reversed = new ArrayList<>();
        for (int i = ans.size() - 1; i >= 0; i--) {
            reversed.add(ans.get(i));
        }

        return reversed;
    }

    private void dfs(int[][] maze, int i, int j, ArrayList<Point> t) {
        // 已被访问
        if (visited[i][j]) {
            return;
        }

        // 障碍物, 退回
        if (maze[i][j] == 1) {
            return;
        }

        // 抵达边缘
        if (i == 0 || i == 3 || j == 0 || j == 3) {
            // 从未找到过路径或右更短路径, 记录该路径
            if (minLength == 0 || t.size() + 1 < minLength) {
                t.add(new Point(i, j));
                minLength = t.size();
                ans = new ArrayList<>(t);
                t.remove(t.size() - 1);
            }
            // 回溯
//
            return;
        }

        // 标记当前位置已被访问, 添加当前结点
        visited[i][j] = true;
        t.add(new Point(i, j));

        // 遍历四周
        //向上
        if (i > 0) {
            dfs(maze, i - 1, j, t);
        }

        //向下
        if (i < 3) {
            dfs(maze, i + 1, j, t);
        }

        //向左
        if (j > 0) {
            dfs(maze, i, j - 1, t);
        }

        //向右
        if (j < 3) {
            dfs(maze, i, j + 1, t);
        }

        // 回溯
        visited[i][j] = false;
        t.remove(t.size() - 1);

    }

    public static void main(String[] args) {
        int[][] maze = new int[][] {
                new int[] {0, 1, 1, 1},
                new int[] {0, 0, 0, 1},
                new int[] {1, 0, 8, 1},
                new int[] {1, 0, 1, 1}
        };

        System.out.println(new Question3().winMazeGift(maze));
    }
}