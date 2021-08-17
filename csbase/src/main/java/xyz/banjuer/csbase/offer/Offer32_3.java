package xyz.banjuer.csbase.offer;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class Offer32_3 {

    private List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        travelLevel(root, 1);
        return result;
    }

    private void travelLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > result.size()) {
            result.add(new LinkedList<>());
        }
        LinkedList<Integer> list = (LinkedList<Integer>) result.get(level - 1);
        if ((level & 1) == 0) {
            list.addFirst(root.val);
        } else {
            list.add(root.val);
        }
        if (root.left != null) travelLevel(root.left, level + 1);
        if (root.right != null) travelLevel(root.right, level + 1);
    }

}
