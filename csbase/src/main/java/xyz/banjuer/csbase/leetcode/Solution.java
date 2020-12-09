package xyz.banjuer.csbase.leetcode;

import xyz.banjuer.common.utils.ArrayUtils;

public class Solution {

    /* ======================单索引入门====================== */

    /**
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 不重复元素索引位
        int nonDupIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[nonDupIndex] && ++nonDupIndex != i) swap(nums, nonDupIndex , i);
        }
        return nonDupIndex + 1;
    }

    /**
     * 27. 移除元素
     *
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // 非目标值索引位
        int notValIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val && ++notValIndex !=i) swap(nums, notValIndex, i);
        }
        return notValIndex + 1;
    }

    /**
     * 80. 删除排序数组中的重复项 II
     * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        // 重复组索引位与保留的元素个数
        int remain = 2;
        int dupIndex = 0, numCount = remain;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[dupIndex]) {
                if (numCount > 1) {
                    dupIndex ++;
                    numCount --;
                    if (dupIndex != i) swap(nums, dupIndex, i);
                }
            } else {
                dupIndex ++;
                numCount = remain;
                if (dupIndex != i) swap(nums, dupIndex, i);
            }
        }
        return dupIndex + 1;
    }

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 0值索引
        // 题意理解错误: 打乱了元素相对顺序
       // int zeroIndex = nums.length;
       // for (int i = 0; i < zeroIndex; i++) {
       //     if (nums[i] == 0) {
       //         zeroIndex --;
       //         while (nums[zeroIndex] == 0) zeroIndex--;
       //         if (zeroIndex != i) swap(nums, zeroIndex, i);
       //     }
       // }
        
        // 非0元素索引位
        int nonZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && ++nonZero != i) swap(nums, nonZero, i);
        }
    }


    private void swap(int[] arr, int sIndex, int tIndex) {
        int tmp = arr[sIndex];
        arr[sIndex] = arr[tIndex];
        arr[tIndex] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ints;
        ints = ArrayUtils.genSorted(15, 10);
        // ints = new int[]{0,0,1,1,1,2,2,3,3,4};
        ArrayUtils.println(ints);
        // int i = s.removeDuplicates(ints);
        // int i = s.removeElement(ints, 2);
        int i = s.removeDuplicates2(ints);
        // s.moveZeroes(ints);
        ArrayUtils.println(ints);
        System.out.println(i);
    }

}
