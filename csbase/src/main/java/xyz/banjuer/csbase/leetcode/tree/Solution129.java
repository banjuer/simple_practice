package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution129 {

    private List<Integer> queue = new ArrayList<>();
    private int sum = 0;
    /**
     * 129.  求根节点到叶节点数字之和
     *
     给你一个二叉树的根节点 root，树中每个节点都存放有一个 0 到 9 之间的数字。
     每条从根节点到叶节点的路径都代表一个数字：
     例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123。
     计算从根节点到叶节点生成的 所有数字之和。
     叶节点 是指没有子节点的节点。
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        queue.add(root.val);
        // 叶子节点
        if (root.left == null && root.right == null) {
            // 计算值
            StringBuilder sb = new StringBuilder();
            List<Integer> path = new ArrayList<>(queue);
            for (Integer integer : path) {
                sb.append(integer);
            }
            sum += Integer.parseInt(sb.toString());
        }
        sumNumbers(root.left);
        sumNumbers(root.right);
        // 回溯
        queue.remove(queue.size() - 1);
        return sum;
    }

}
