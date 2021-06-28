package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution230 {

    /**
     * 230. 二叉搜索树中第K小的元素
     *
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     */
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历到第N个结束
        Stack<Integer> stack = new Stack<>();
        inorderKth(root, stack, k);
        // 最后一个元素就是第K
        return stack.pop();
    }

    private void inorderKth(TreeNode root, Stack<Integer> stack, int k) {
        if (root == null) {
            return;
        }
        inorderKth(root.left, stack, k);
        // 查完左子树完毕后查看是否到达目标
        if (stack.size() == k) {
            return;
        }
        stack.push(root.val);
        inorderKth(root.right, stack, k);
    }

    /**
     * 使用中序遍历后取第k
     */
    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> path = new ArrayList<>();
        inorder(root, path);
        return path.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }

}
