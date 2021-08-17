package leetcode.searchRange;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases
 * @author Zefeng Wang
 */

public class SolutionTest {
    private int[] nums;
    private int target;
    private int[] answer;
    private final Solution solution = new Solution();

    @Test
    public void testCase1() {
        nums = new int[] {};
        target = 0;
        answer = new int[] {-1, -1};
        assertionHelper(nums, target, answer);
    }

    @Test
    public void testCase2() {
        nums = new int[] {5, 7, 7, 8, 8, 10};
        target = 6;
        answer = new int[] {-1, -1};
        assertionHelper(nums, target, answer);
    }

    @Test
    public void testCase3() {
        nums = new int[] {5, 7, 7, 8, 8, 10};
        target = 8;
        answer = new int[] {3, 4};
        assertionHelper(nums, target, answer);
    }

    /**
     * helper function
     * @param nums input nums
     * @param target input target
     * @param answer expected answer
     */
    private void assertionHelper(int[] nums, int target, int[] answer) {
        Assert.assertArrayEquals(answer, solution.searchRange(nums, target));
    }
}
