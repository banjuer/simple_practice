package xyz.banjuer.csbase.leetcode.stack;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {

    /**
     * 当前递归函数的指令内容:
     * 1. 访问元素
     * 2. 跳转继续执行函数
     */
    class Command {
        /**
         * 跳转:go(新栈)
         * 访问:access
         */
        String order;
        TreeNode node;
        Command(String order, TreeNode node) {
            this.order = order;
            this.node = node;
        }
    }

    /**
     * 94. 二叉树的中序遍历
     *
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        // 使用栈模拟函数调用
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));

        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if ("access".equals(command.order)) {
                list.add(command.node.val);
            } else {
                // pop访问时，左根右访问顺序故入栈顺序应该是右根左
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                stack.push(new Command("access", command.node));
                // 模拟递归终止
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
        return list;
    }

    /**
     * 递归方案
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

}
