package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

import java.util.Stack;

public class Solution98 {

    /**
     * 中序遍历
     */
    public boolean isValidBST4(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            // 左节点持续入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 到达左叶子节点
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            // 叶子节点右节点， 栈不为空，接下来下一个元素会出栈直到右节点不为空
            root = root.right;
        }
        return true;
    }

    /**
     * 98. 验证二叉搜索树
     *
     给定一个二叉树，判断其是否是一个有效的二叉搜索树。

     假设一个二叉搜索树具有如下特征：
     节点的左子树只包含小于当前节点的数。
     节点的右子树只包含大于当前节点的数。
     所有左子树和右子树自身必须也是二叉搜索树。
     */
    public boolean isValidBST(TreeNode root) {
        /*
         * 当前节点大于所有左节点值且小于所有右节点:
         * 转换->
         * 当前节点左子树取值范围应该在[min, root.val), 右子树在(root.val, max]
         */

        return valid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    /**
     * 检查节点是否均在(u,l)开区间之间
     */
    private boolean valid(TreeNode node, long upper, long lower) {
        // 查到空节点(之前均检查通过，故此时为true)
        if (node == null) {
            return true;
        }
        // 当前节点符合搜索树，则向左右查找判断
        if (node.val > lower && node.val < upper) {
            return valid(node.left, node.val, lower) && valid(node.right, upper, node.val);
        }
        // 检查为通过false
        return false;
    }

    /**
     * 错误解:
     * 值判断当前节点的取值是不对的
     */
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 到达叶子节点, 之前节点都已检查通过，故此时为true
        if (root.left == null && root.right == null) {
            return true;
        }
        // 默认当前是二分搜索树（），当前节点非叶子节点是否为搜索树
        boolean isBST = true;
        if (root.left != null) {
            isBST = root.val > root.left.val;
        }
        if (root.right != null) {
            isBST = isBST && root.val < root.right.val;
        }
        return isBST && isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);

        Solution98 solution98 = new Solution98();
        boolean validBST = solution98.isValidBST(root);
        System.out.println(validBST);
    }

}
