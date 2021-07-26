package leetcode.hot100.combinationSum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Test cases
 * @author Zefeng Wang
 */

public class SolutionTest {
    private int[] candidates;
    private int target;
    private final Solution solution = new Solution();

    @Test
    public void testCase1() {
        candidates = new int[] {1};
        target = 1;
        List<List<Integer>> actualOutput = solution.combinationSum(candidates, target);
        Assert.assertTrue(in(Collections.singletonList(1), actualOutput));
    }

    @Test
    public void testCase2() {
        candidates = new int[] {1};
        target = 2;
        List<List<Integer>> actualOutput = solution.combinationSum(candidates, target);
        Assert.assertTrue(in(Arrays.asList(1, 1), actualOutput));
    }

    @Test
    public void testCase3() {
        candidates = new int[] {2};
        target = 1;
        List<List<Integer>> actualOutput = solution.combinationSum(candidates, target);
        Assert.assertEquals(0, actualOutput.size());
    }

    @Test
    public void testCase4() {
        candidates = new int[] {2,3,5};
        target = 8;
        List<List<Integer>> actualOutput = solution.combinationSum(candidates, target);
        Assert.assertTrue(in(Arrays.asList(2, 2, 2, 2), actualOutput));
        Assert.assertTrue(in(Arrays.asList(2, 3, 3), actualOutput));
        Assert.assertTrue(in(Arrays.asList(3, 5), actualOutput));
    }

    @Test
    public void testCase5() {
        candidates = new int[] {2,3,6, 7};
        target = 7;
        List<List<Integer>> actualOutput = solution.combinationSum(candidates, target);
        Assert.assertTrue(in(Collections.singletonList(7), actualOutput));
        Assert.assertTrue(in(Arrays.asList(2, 2, 3), actualOutput));
    }

    private boolean in(List<Integer> child, List<List<Integer>> parent) {
        if (child == null) {
            throw new NullPointerException("child is null, expected not null");
        }
        if (parent == null) {
            throw new NullPointerException("parent is null, expected not null");
        }
        for (List<Integer> list : parent) {
            if (sameList(child, list)) {
                return true;
            }
        }
        return false;
    }

    private boolean sameList(List<Integer> a, List<Integer> b) {
        if (a == null && b == null) {
            return true;
        }
        if (a != null && b != null) {
            if (a.size() != b.size()) {
                return false;
            } else {
                Collections.sort(a);
                Collections.sort(b);
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


}
