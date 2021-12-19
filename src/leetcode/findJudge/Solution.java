package leetcode.findJudge;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/find-the-town-judge/
 * @author Zefeng Wang
 */

public class Solution {
//    public int findJudge(int n, int[][] trust) {
//        // base case: n = 1
//        if (n == 1 && trust.length == 0) {
//            return 1;
//        }
//
//        Set<Integer> candidates = new HashSet<>();
//
//        // initialize all candidates
//        for (int[] item : trust) {
//            candidates.add(item[1]);
//        }
//
//        // check all judges
//        for (Integer candidate : candidates) {
//            int count = 0;
//            boolean flag = true;
//            for (int i = 0; i < trust.length; i++) {
//                if (trust[i][0] == candidate) {
//                    flag = false;
//                }
//                if (trust[i][1] == candidate) {
//                    count++;
//                }
//            }
//            if (flag && count == n-1) {
//                return candidate;
//            }
//        }
//
//        return -1;
//    }

    /**
     * Official Solution
     */
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] edge : trust) {
            int x = edge[0], y = edge[1];
            ++inDegrees[y];
            ++outDegrees[x];
        }
        for (int i = 1; i <= n; ++i) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void test(int n, int[][] trust, int expected) {
        Solution solution = new Solution();
        if (solution.findJudge(n, trust) == expected) {
            System.out.println("pass.");
        } else {
            System.out.println("fail.");
            System.out.println("- Actual: " + solution.findJudge(n, trust));
            System.out.println("- Expected: " + expected);
        }
    }

    public static void main(String[] args) {
        // Test variables;

        // Test case 1
        test(2, new int[][] {new int[] {1,2}}, 2);
        // Test case 2
        test(3, new int[][] {new int[] {1, 3}, new int[] {2, 3}}, 3);
        // Test case 3
        test(3, new int[][] {new int[] {1, 3}, new int[] {2, 3}, new int[] {3, 1}}, -1);
        // Test case 4
        test(3, new int[][] {new int[] {1, 2}, new int[] {2, 3}}, -1);
        // Test case 5
        test(4, new int[][] {new int[] {1, 3},  new int[] {1, 4}, new int[] {2, 3}, new int[] {2, 4}, new int[] {4, 3}}, 3);
        //Test case 6
        test(1, new int[][] {}, 1);
    }
}
