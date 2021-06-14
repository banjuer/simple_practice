package xyz.banjuer.csbase.leetcode.queue;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution103 {

    class Tuple {
        int level;
        TreeNode node;

        public Tuple(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    /**
     * 103. 二叉树的锯齿形层序遍历
     *
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Tuple> queue = new ArrayDeque<>();
        queue.offer(new Tuple(0, root));
        boolean left = true;
        while (!queue.isEmpty()) {
            Tuple poll = queue.poll();
            int level = poll.level;
            TreeNode node = poll.node;
            List<Integer> list;
            if (res.size() <= poll.level) {
                list = new ArrayList<>();
                res.add(list);
                left = !left;
            } else {
                list = res.get(level);
            }
            list.add(node.val);
            if (left) {
                if (node.left != null) {
                    queue.offer(new Tuple(level + 1, node.left));
                }
                if (node.right != null) {
                    queue.offer(new Tuple(level + 1, node.right));
                }
            } else {
                if (node.right != null) {
                    queue.offer(new Tuple(level + 1, node.right));
                }
                if (node.left != null) {
                    queue.offer(new Tuple(level + 1, node.left));
                }
            }
        }
        return res;
    }

}
