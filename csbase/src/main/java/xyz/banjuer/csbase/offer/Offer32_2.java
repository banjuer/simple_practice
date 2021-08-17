package xyz.banjuer.csbase.offer;

import xyz.banjuer.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class Offer32_2 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        travelBf(root, 1);
        return result;
    }

    private void travelBf(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() < level) {
            result.add(new ArrayList<>());
        }
        List<Integer> list = result.get(level - 1);
        list.add(root.val);
        travelBf(root.left, level + 1);
        travelBf(root.right, level + 1);
    }

}
