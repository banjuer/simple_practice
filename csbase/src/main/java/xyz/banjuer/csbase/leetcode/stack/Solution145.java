package xyz.banjuer.csbase.leetcode.stack;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution145 {

    /**
     * 145. 二叉树的后序遍历
     *
     * 给定一个二叉树，返回它的 后序 遍历。
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(list, root);
        return list;
    }

    private void postorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(list, root.left);
        postorder(list, root.right);
        list.add(root.val);
    }

    class Command{
        String order;
        TreeNode node;

        public Command(String order, TreeNode node) {
            this.order = order;
            this.node = node;
        }
    }

    /**
     * 栈模拟
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));

        while (!stack.isEmpty()) {
            Command pop = stack.pop();
            if ("access".equals(pop.order)) {
                list.add(pop.node.val);
            } else {
                stack.push(new Command("access", pop.node));
                if (pop.node.right != null) {
                    stack.push(new Command("go", pop.node.right));
                }
                if (pop.node.left != null) {
                    stack.push(new Command("go", pop.node.left));
                }
            }
        }
        return list;
    }

}
