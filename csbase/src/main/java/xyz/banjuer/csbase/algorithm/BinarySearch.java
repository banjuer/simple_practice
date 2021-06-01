package xyz.banjuer.csbase.algorithm;

import xyz.banjuer.common.utils.ListUtils;

public class BinarySearch {

    public static int findIndexRecursion(int[] nums, int target) {
        return findIndex(nums, target, 0, nums.length - 1);
    }

    /**
     * [l, r]区间内查找target
     */
    private static int findIndex(int[] nums, int target, int l, int r) {
        // c
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return findIndex(nums, target, l, mid - 1);
        else return findIndex(nums, target, mid + 1, r);
    }

    public static int findIndex(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = ListUtils.genSorted(100, 100);
        ListUtils.println(nums);
        int target = 32;
        // int index = findIndexRecursion(nums, target);
        int index = findIndex(nums, target);
        System.out.printf("index: %d, target:%d\n", index, target);
    }

}
