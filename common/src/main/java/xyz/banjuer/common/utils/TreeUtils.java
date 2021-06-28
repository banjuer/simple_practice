package xyz.banjuer.common.utils;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {

    /**
     * 按层级创建树
     */
    public static TreeNode createTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        // i:待添加元素索引位置
        int i = 0;
        TreeNode root = new TreeNode(arr[i++]);
        queue.offer(root);
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode poll = queue.poll();
            TreeNode left = null;
            if (arr[i] != null) {
                left = new TreeNode(arr[i++]);
            }
            poll.left = left;
            TreeNode right = null;
            if (i < arr.length && arr[i] != null) {
                right = new TreeNode(arr[i]);
            }
            poll.right = right;
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }

        }
        return root;
    }

    public static Integer[] bfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return result.toArray(new Integer[]{});
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,1,4,null,2};
        TreeNode root = createTree(arr);
        ListUtils.println(bfs(root));
    }

}
