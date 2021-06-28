package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution113 {

    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 113. 路径总和 II
     *
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        dfs(path, root, targetSum);
        return res;
    }

    private void dfs(List<Integer> path, TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        targetSum = targetSum - node.val;
        // 到达叶子节点时，满足条件则把过程中节点转成list放到结果集
        if (node.left == null && node.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        // 左右子树查找
        dfs(path, node.left, targetSum);
        dfs(path, node.right, targetSum);
        // 查找结束回溯到上一节点
        path.remove(path.size() - 1);
    }

}
