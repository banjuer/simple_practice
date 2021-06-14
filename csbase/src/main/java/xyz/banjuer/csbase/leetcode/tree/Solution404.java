package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

public class Solution404 {

    /**
     * 404. 左叶子之和
     * 计算给定二叉树的所有左叶子之和。
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    /**
     * 递归:
     * 当前函数只实现当前节点的处理逻辑！！
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // 当前节点的逻辑
        if (root == null) {
            return 0;
        }
        // 如果当前节点左子树为叶子节点，则记录为当前节点的值
        int ans = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans = root.left.val;
        }
        // 当前节点值+左右叶子节点的值
        return ans + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    /**
     * 深度优先计算
     */
    private int dfs(TreeNode node) {
        int ans = 0;
        // 左子树不为空
        if (node.left != null) {
            ans = isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        // 右子树未非叶子节点
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
