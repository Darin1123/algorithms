package leetcode.levelOrder;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @author Zefeng Wang
 *
 * 思路一, 维持一个 Map, 以 层数 为键, 然后以深度优先遍历该数, 在遍历时记录当前的
 * 层数, 然后添加到这个 Map 中. 遍历结束后将这个 Map 中的值按照 层数 进行排序然后
 * 转换成目标类型.
 *
 *
 *
 */

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        dfs(root, map, 1);

        for (Integer key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }

    private void dfs(TreeNode root, Map<Integer, List<Integer>> map, int i) {
        if (root == null) {
            return;
        }

        if (map.get(i) != null) {
            map.get(i).add(root.val);
        } else {
            List<Integer> t = new ArrayList<>();
            t.add(root.val);
            map.put(i, t);
        }
        dfs(root.left, map, i + 1);
        dfs(root.right, map, i + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(20, new TreeNode(15), new TreeNode(7)), new TreeNode(9) );
        new Solution().levelOrder(root);
    }
}
