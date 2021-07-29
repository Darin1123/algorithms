package leetcode.hot100.trap;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zefeng Wang
 */

public class SolutionTest {
    private int[] height;
    private final Solution solution = new Solution();

    @Test
    public void testCase1() {
        height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Assert.assertEquals(6, solution.trap(height));
    }

    @Test
    public void testCase2() {
        height = new int[] {4, 2, 0, 3, 2, 5};
        Assert.assertEquals(9, solution.trap(height));
    }
}
