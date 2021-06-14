package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

public class Solution222 {

    /**
     * 222. 完全二叉树的节点个数
     *
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 使用完全二叉树性质
     * 当右子树深度与左子树深度相同，左子树个数：2^h(l) -1 + 1
     * 当深度不同,多余叶子节点在左，右子树个数2^h(r) - 1 + 1
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = depth(root.left);
        int hr = depth(root.right);
        if (hl == hr) {
            // 左子树满，多余在右
            return (1 << hl) + countNodes2(root.right);
        } else {
            // 多余叶子节点在左
            return (1 << hr) + countNodes2(root.left);
        }
    }

    private int depth(TreeNode node) {
        int d = 0;
        while (node != null) {
            node = node.left;
            d++;
        }
        return d;
    }

}
