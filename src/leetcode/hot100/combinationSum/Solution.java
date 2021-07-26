package leetcode.hot100.combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * ## 解题思路: 回溯算法
 *
 * @author Zefeng Wang
 */

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {  // one success combination
            ans.add(new ArrayList<>(combine));  // deep copy
        }
        // skip current candidate number
        dfs(candidates, target, ans, combine, idx + 1);
        // try current candidate number
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
