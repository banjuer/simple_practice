package xyz.banjuer.csbase.offer;

import xyz.banjuer.common.entity.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return travelCmp(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean travelCmp(TreeNode A, TreeNode B) {
        if (B == null) {
            // 右子树已完全匹配
            return true;
        }
        if (A == null) {
            // A已完全匹配，B仍有子树
            return false;
        }
        return A.val == B.val && travelCmp(A.left, B.left) && travelCmp(A.right, B.right);
    }

}
