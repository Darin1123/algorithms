package leetcode.numberOfArithmeticSlices;

/**
 * 2021/08/10
 * @author Zefeng Wang
 */

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // robust code
        if (nums == null || nums.length < 3) {
            return 0;
        }

        // initialize states
        int lo = 0, hi = 1;  // slide window pointers
        int diff = nums[hi] - nums[lo], result = 0;  // current difference and the result

        // while loop
        while (hi < nums.length) {
            // if the new diff is NOT equal to the old diff,
            // then make lo = hi, hi = hi + 1, update the new difference, increment result
            if ((nums[hi] - nums[hi - 1]) != diff) {
                if (hi - 1 - lo >= 2) {
                    result += numOfSlices(hi - lo);
                }
                diff = nums[hi] - nums[hi - 1];
                lo = hi - 1;
            } else if (hi == nums.length - 1) {
                result += numOfSlices(hi - lo + 1);
                return result;
            }

            hi++;  // move hi to the right
        }
        return result;
    }

    private int numOfSlices(int size) {
        return (size - 1) * (size - 2) / 2;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        System.out.println(new Solution().numberOfArithmeticSlices(nums));
    }
}
