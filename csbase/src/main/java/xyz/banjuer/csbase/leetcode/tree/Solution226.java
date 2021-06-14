package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

public class Solution226 {

    /**
     * 226. 翻转二叉树
     *
     * 翻转一棵二叉树。
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        invertTree(left);
        invertTree(right);
        return root;
    }

}
