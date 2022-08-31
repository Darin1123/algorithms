package leetcode.longestConsecutive;

import java.util.Arrays;

/**
 * @author Zefeng Wang
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 */

public class Solution {
    /**
     * # 解题思路:
     * (一)
     * 排序, 然后遍历. 时间复杂度: O(nlogn)
     *
     * (二)
     * 第一次遍历: 找到最大值和最小值
     * 创建长度为最大值 - 最小值的数组
     * 第二次遍历: 将数字填入
     * 第三次遍历: 找到最长序列
     * > 时间复杂度 O(n)
     *
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int lo = nums[0];
        int hi = nums[0];

        for (int num : nums) {
            if (num > hi) {
                hi = num;
            }
            if (num < lo) {
                lo = num;
            }
        }

        boolean[] map = new boolean[hi - lo + 1];

        for (int num : nums) {
            map[num - lo] = true;
        }

        int res = 0;

        int t = 0;

        for (int i = 0; i < map.length; i++) {
            boolean b = map[i];

            if (b) {
                t++;
            } else {
                res = Math.max(t, res);
                t = 0;
            }
            if (i == map.length - 1 && t > res) {
                res = t;
            }
        }

        return res;
    }

    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int res = 1;

        int t = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= 1) {
                t += nums[i] - nums[i - 1];
            } else {
                if (t > res) {
                    res = t;
                }
                t = 1;
            }

            if (i == nums.length - 1 && t > res) {
                res = t;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0,3,7,2,5,8,4,6,0,1 };
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
