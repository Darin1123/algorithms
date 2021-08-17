package leetcode.circularArrayLoop;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases
 * @author Zefeng Wang
 */

public class SolutionTest {
    private int[] nums;
    private final Solution solution = new Solution();

    @Test
    public void testCase1() {
        nums = new int[] {2, -1, 1, 2, 2};
        Assert.assertTrue(solution.circularArrayLoop(nums));
    }

    @Test
    public void testCase2() {
        nums = new int[] {-1, 2};
        Assert.assertFalse(solution.circularArrayLoop(nums));
    }

    @Test
    public void testCase3() {
        nums = new int[] {-2, 1, -1, -2, -2};
        Assert.assertFalse(solution.circularArrayLoop(nums));
    }

    @Test
    public void testCase4() {
        nums = new int[] {-1, -2, -3, -4, -5};
        Assert.assertFalse(solution.circularArrayLoop(nums));
    }

    @Test
    public void testCase5() {
        nums = new int[] {-1};
        Assert.assertFalse(solution.circularArrayLoop(nums));
    }
}
