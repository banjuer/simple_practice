package xyz.banjuer.csbase.offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class Offer53 {

    public int search(int[] nums, int target) {
        // [l, r] [l,m] [m+1,r]
        boolean found = false;
        int l = 0, r = nums.length - 1, m = -1;
        while (l <= r) {
            m = (r - l) / 2 + l;
            if (nums[m] > target) {
                // 向左
                r = m - 1;
            } else if (nums[m] < target) {
                // 向右
                l = m + 1;
            } else {
                found = true;
                break;
            }
        }
        // 没找到
        if (!found) {
            return 0;
        }
        int count = 1;
        // 向前计数
        int i = m - 1;
        while (i >= 0 && nums[i] == target) {
            count++;
            i--;
        }
        // 向后计数
        i = m + 1;
        while (i < nums.length && nums[i] == target) {
            count++;
            i++;
        }
        return count;

    }

    public static void main(String[] args) {
        int[] ints = new int[]{5,7,7,8,8,10};
        int t = 8;
        System.out.println(new Offer53().search(ints, t));
    }

}
