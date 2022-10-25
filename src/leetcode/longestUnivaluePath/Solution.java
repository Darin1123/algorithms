package leetcode.longestUnivaluePath;

import util.TreeNode;

public class Solution {
    private int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }


        return res;
    }

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5,
//                new TreeNode(4, new TreeNode(1), new TreeNode(1)),
//                new TreeNode(5, null, new TreeNode(5)));
//
////        TreeNode root = new TreeNode(1,
////                new TreeNode(4, new TreeNode(4), new TreeNode(4)),
////                new TreeNode(5, null, new TreeNode(5)));
//
//        System.out.println(new Solution().longestUnivaluePath(root));
//    }
}
