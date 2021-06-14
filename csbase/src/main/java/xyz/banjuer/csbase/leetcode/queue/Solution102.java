package xyz.banjuer.csbase.leetcode.queue;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution102 {

    class Tuple {
        int level;
        TreeNode node;

        public Tuple(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    /**
     * 102. 二叉树的层序遍历
     *
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Tuple> queue = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        queue.add(new Tuple(0, root));
        while (!queue.isEmpty()) {
            Tuple poll = queue.poll();
            List<Integer> list;
            if (res.size() <= poll.level) {
                list = new ArrayList<>();
                res.add(list);
            } else {
                list = res.get(poll.level);
            }
            list.add(poll.node.val);
            if (poll.node.left != null) {
                queue.offer(new Tuple(poll.level + 1, poll.node.left));
            }
            if (poll.node.right != null) {
                queue.offer(new Tuple(poll.level + 1, poll.node.right));
            }
        }
        return res;
    }

}
