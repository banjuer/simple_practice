package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

public class Solution111 {

    /**
     * 111. 二叉树的最小深度
     *
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 到达叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 左右子树都不为空
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        // 左子树不为空右子树为空
        if (root.left != null) {
            return minDepth(root.left) + 1;
        }
        return minDepth(root.right) + 1;
    }

}
