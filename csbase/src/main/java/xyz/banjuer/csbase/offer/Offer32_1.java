package xyz.banjuer.csbase.offer;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Offer32_1 {

    public int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return toInt(result);
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            result.add(poll.val);
            if (poll.left != null) {
                q.offer(poll.left);
            }
            if (poll.right != null) {
                q.offer(poll.right);
            }
        }
        return toInt(result);
    }

    private int[] toInt(List<Integer> result) {
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }



}
