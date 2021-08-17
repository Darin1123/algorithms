package leetcode.circularArrayLoop;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目链接: https://leetcode-cn.com/problems/circular-array-loop/
 * @author Zefeng Wang
 */

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return false;
            }
            if (goThrough(nums, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean goThrough(int[] nums, int start) {
        Set<Integer> route = new HashSet<>();
        boolean sign = nums[start] > 0;
        int index = start;
        int oldIndex = 0;
        while (!route.contains(index)) {
            if (nums[index] == 0) {
                return false;
            }
            if ((nums[index] > 0) != sign) {
                return false;
            }
            route.add(index);
            oldIndex = index;
            index = nextIndex(nums, index);
            nums[oldIndex] = 0;
        }
        return route.size() > 1 && oldIndex != index;
    }

    private int nextIndex(int[] nums, int start) {
        int N = nums.length;
        int newStart = start + nums[start];
        if (newStart >= N) {
            return newStart % N;
        } else if (newStart < 0) {
            return N + (newStart % N);
        } else {
            return newStart;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {-1};
        System.out.println(solution.circularArrayLoop(nums));
    }
}
