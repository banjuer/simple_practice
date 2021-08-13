package xyz.banjuer.csbase.offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer53_2 {

    public int missingNumber(int[] nums) {
        int l = 0 , r = nums.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            // 相等时在➡️
            if (nums[m] == m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

}
