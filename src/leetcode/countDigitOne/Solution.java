package leetcode.countDigitOne;

import java.util.Arrays;

/**
 * @author Zefeng Wang
 */

public class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        for (int i = 0; i < n + 1; i++) {
            helper(i, memo);
        }
        for (Integer i : memo) {
            res += i;
        }
        return res;
    }

    private int helper(int n, int[] memo) {
        if (memo[n] != -1) { return memo[n]; }

        if (n < 10) {
            if (n == 1) {
                memo[1] = 1;
            } else {
                memo[n] = 0;
            }
            return memo[n];
        }

        int res = helper(n / 10, memo) + helper(n % 10, memo);
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int res = new Solution().countDigitOne(824883294);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        System.out.println("ans: " + res);
//        System.out.println(101 / 10);
    }
}
