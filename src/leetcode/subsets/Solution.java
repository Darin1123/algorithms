package leetcode.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zefeng Wang
 */

public class Solution {
    // "recursive" implementation
    public List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();  // new batch, []
            for (List<Integer> subset : result) {
                List<Integer> newSubset = new ArrayList<>(subset);  // deep copy
                newSubset.add(num);  // add the new number
                newSubsets.add(newSubset);  // add new subset to the new batch
            }
            result.addAll(newSubsets);  // add new batch into final answer
        }

        return result;
    }



    // back-tracing implementation
    private final List<List<Integer>> result = new ArrayList<>();
    private int n;

    public List<List<Integer>> subsetsBackTracing(int[] nums) {
        n = nums.length;
        for (int k = 0; k <= n; k++) {
            backTrack(0, k, new ArrayList<Integer>(), nums);
        }
        return this.result;
    }

    private void backTrack(int start, int k, ArrayList<Integer> cur, int[] nums) {
        if (k == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < n; i++) {
            cur.add(nums[i]);
            backTrack(i + 1, k - 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
