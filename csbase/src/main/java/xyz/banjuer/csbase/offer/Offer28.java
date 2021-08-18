package xyz.banjuer.csbase.offer;

import xyz.banjuer.common.entity.TreeNode;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Offer28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null) return false;
        return L.val == R.val && helper(L.left, R.right) && helper(L.right, R.left);
    }

}
