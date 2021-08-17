package leetcode.findMedianSortedArrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zefeng Wang
 */

public class SolutionTest {
    private final static double TOLERANCE = 0.000000001;
    private int[] nums1;
    private int[] nums2;
    private final Solution solution = new Solution();

    @Test
    public void testCase1() {
        nums1 = new int[] {1,3,4,6,9};
        nums2 = new int[] {2,4,6};
        double actual = solution.findMedianSortedArrays(nums1, nums2);
        double expected = 4.0;
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertTrue(almostEquals(actual, expected));
    }

    private boolean almostEquals(double actual, double expected) {
        return Math.abs(actual - expected) < TOLERANCE;
    }
}
