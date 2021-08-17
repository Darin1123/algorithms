package leetcode.unhappyFriends;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/count-unhappy-friends/
 *
 * @author Zefeng Wang
 */

public class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] order = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                order[i][preferences[i][j]] = j;
            }
        }

        Set<Integer> unhappyPeople = new HashSet<>();

        for (int i = 0; i < pairs.length; i++) {
            for (int j = i + 1; j < pairs.length; j++) {
                checkUnhappy(pairs[i], pairs[j], order, unhappyPeople);
            }
        }
        return unhappyPeople.size();
    }

    private void checkUnhappy(int[] p1, int[] p2, int[][] order, Set<Integer> unhappyPeople) {
        if (!unhappyPeople.contains(p1[0])) {
            if (unhappy(p1[0], p1[1], p2[0], p2[1], order)) {
                unhappyPeople.add(p1[0]);
            } else if (unhappy(p1[0], p1[1], p2[1], p2[0], order)) {
                unhappyPeople.add(p1[0]);
            }
        }
        if (!unhappyPeople.contains(p1[1])) {
            if (unhappy(p1[1], p1[0], p2[0], p2[1], order)) {
                unhappyPeople.add(p1[1]);
            } else if (unhappy(p1[1], p1[0], p2[1], p2[0], order)) {
                unhappyPeople.add(p1[1]);
            }
        }

        if (!unhappyPeople.contains(p2[0])) {
            if (unhappy(p2[0], p2[1], p1[0], p1[1], order)) {
                unhappyPeople.add(p2[0]);
            } else if (unhappy(p2[0], p2[1], p1[1], p1[0], order)) {
                unhappyPeople.add(p2[0]);
            }
        }

        if (!unhappyPeople.contains(p2[1])) {
            if (unhappy(p2[1], p2[0], p1[0], p1[1], order)) {
                unhappyPeople.add(p2[1]);
            } else if (unhappy(p2[1], p2[0], p1[1], p1[0], order)) {
                unhappyPeople.add(p2[1]);
            }
        }

    }

    private boolean unhappy(int x, int y, int u, int v, int[][] order) {
        return order[x][u] < order[x][y] && order[u][x] < order[u][v];
    }

    public static void main(String[] args) {
//        int n = 4;
//        int[][] preferences = new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
//        int[][] pairs = new int[][]{{0, 1}, {2, 3}};
        int n = 6;
        int[][] preferences = new int[][]{{4,2,5,3,1}, {5,3,2,4,0}, {3,5,4,0,1}, {0,5,1,2,4}, {2,5,1,0,3}, {2,4,3,0,1}};
        int[][] pairs = new int[][]{{2,4}, {1,5}, {0,3}};
        System.out.println(new Solution().unhappyFriends(n, preferences, pairs));
    }
}
