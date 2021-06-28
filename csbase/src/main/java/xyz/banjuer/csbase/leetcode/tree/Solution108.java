package xyz.banjuer.csbase.leetcode.tree;

import xyz.banjuer.common.entity.TreeNode;

public class Solution108 {

    /**
     * 108.  将有序数组转换为二叉搜索树
     *
     * 给你一个整数数组 nums，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1」的二叉树。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 每次选择中间节点元素作为根节点
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * [l,r]闭区间新建树
     */
    private TreeNode helper(int[] nums, int l, int r) {
        if (r < l) {
            return null;
        }
        int mid = (r - l) / 2 + l;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);
        return root;
    }

}
