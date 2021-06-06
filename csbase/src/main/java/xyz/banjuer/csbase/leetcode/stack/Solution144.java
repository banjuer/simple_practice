package xyz.banjuer.csbase.leetcode.stack;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144 {

    /**
     * 144. 二叉树的前序遍历
     *
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(list, root);
        return list;
    }

    private void preorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }


    class Command {
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
    public List<Integer> preorderTraversal2(TreeNode root) {
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
                // 前序遍历:根左右,故入栈顺序因为右左根
                if (pop.node.right != null) {
                    stack.push(new Command("go", pop.node.right));
                }
                if (pop.node.left != null) {
                    stack.push(new Command("go", pop.node.left));
                }
                stack.push(new Command("access", pop.node));
            }
        }

        return list;
    }

}
