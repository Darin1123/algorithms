package leetcode.tribonacci;


/**
 * 题目链接: https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * @author Zefeng Wang
 */

class Solution {
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        int t;
        switch (n) {
            case 0: return a;
            case 1: return b;
            case 2: return c;
        }
        for (int i = 0; i < n - 2; i++) {
            t = a + b + c;
            a = b;
            b = c;
            c = t;
        }
        return c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tribonacci(25));
    }
}
