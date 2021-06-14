package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

public class Solution110 {

    /**
     * 110. 平衡二叉树
     *
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.right) - height(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * 自底向上On
     */
    public boolean isBalanced(TreeNode root) {
        return height2(root) >= 0;
    }

    private int height2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 先计算左右高度
        int left = height2(node.left) + 1;
        int right = height2(node.right) + 1;
        // 此时不平衡
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
