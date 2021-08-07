package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution257 {

    /**
     * 257. 二叉树的所有路径
     *
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     */
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return result;
    }

    private List<String> result = new ArrayList<>();
    private List<Integer> queue = new ArrayList<>();

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(q2String());
        }
        dfs(root.left);
        dfs(root.right);
        queue.remove(queue.size() - 1);
    }

    private String q2String() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queue.size(); i++) {
            sb.append(queue.get(i));
            if (i != queue.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }

}
