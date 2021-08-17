package leetcode.hasPathSum;

/**
 * https://leetcode-cn.com/leetbook/read/dfs/e8gh3h/
 * @author Zefeng Wang
 */

public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int val = root.val;
        if (root.left == null && root.right == null && val == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum - val) || hasPathSum(root.right, targetSum - val);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2), null);

        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(node, 1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
