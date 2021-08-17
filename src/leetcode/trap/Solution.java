package leetcode.trap;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author Zefeng Wang
 */

public class Solution {
    public int trap(int[] height) {
        int N = height.length;

        if (N < 3) {
            return 0;
        }

        int[] leftMax = new int[N];
        int[] rightMax = new int[N];

        leftMax[0] = height[0];
        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[N - 1] = height[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

//        System.out.println(Arrays.toString(leftMax));
//        System.out.println(Arrays.toString(rightMax));

        int ans = 0;

        for (int i = 0; i < N; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }
}
