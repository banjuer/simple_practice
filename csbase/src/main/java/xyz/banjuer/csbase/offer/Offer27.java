package xyz.banjuer.csbase.offer;

import xyz.banjuer.common.entity.TreeNode;

/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

}
