package leetcode.hot100.searchRange;

/**
 * 题目描述:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * @author Zefeng Wang
 */

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        // handle null and empty array
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        // perform binary search to find one target
        int left = leftBinarySearch(nums, target);

        // if left is -1, target not in nums, return [-1, -1]
        if (left == -1) {
            return new int[] {-1, -1};
        }

        // get right index
        int right = rightBinarySearch(nums, target);

        // return answer
        return new int[] {left, right};
    }

    /**
     * left binary search. find the left-most target position. if not found, return -1.
     * @param nums input numbers
     * @param target target number
     * @return index.
     */
    private int leftBinarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if      (target < nums[mid])    hi = mid - 1;
            else if (target > nums[mid])    lo = mid + 1;
            else                            hi = mid;
        }
        if (nums[lo] == target) {
            return lo;
        }
        return -1;
    }

    /**
     * right binary search. find the right-most target position. if not found, return -1.
     * @param nums input numbers
     * @param target target number
     * @return index.
     */
    private int rightBinarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;  // 注意这里要向上取整, 否则会进入死循环
            System.out.println(lo + ", " + hi + ", " + mid);
            if      (target < nums[mid])    hi = mid - 1;
            else if (target > nums[mid])    lo = mid + 1;
            else                            lo = mid;
        }
        if (nums[hi] == target) {
            return hi;
        }
        return -1;
    }
}
