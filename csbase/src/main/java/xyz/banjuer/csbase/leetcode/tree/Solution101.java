package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

public class Solution101 {

    /**
     * 101. 对称二叉树
     *
     * 给定一个二叉树，检查它是否是镜像对称的。
     */
    public boolean isSymmetric(TreeNode root) {
        /*
         * 逻辑转换: 两个树在什么情况下互为镜像？
         * 1.左子树与另一颗树的右子树相同
         * 2.右子树与另一颗树的左子树相同
         */
        return checkTree(root, root);
    }

    private boolean checkTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && checkTree(p.left, q.right) && checkTree(p.right, q.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        /*
         * 迭代:
         * 引入队列，每次把当前节点两次入队，出队时分别比较两个节点的左右子树，逻辑同上
         */
        return false;
    }

}
