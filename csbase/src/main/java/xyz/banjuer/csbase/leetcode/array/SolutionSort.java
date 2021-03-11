package xyz.banjuer.csbase.leetcode.array;

import xyz.banjuer.common.utils.ArrayUtils;
import xyz.banjuer.common.utils.SortUtils;

/**
 * 排序与衍生问题
 */
public class SolutionSort {

    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     */
    public void sortColors1(int[] nums) {
        //  1.常规思路: 计数后遍历写回 需要两次遍历
        int[] colorCount = new int[3];
        for (int num : nums) {
            colorCount[num]++;
        }
        int i = 0;
        for (; i < colorCount[0]; i++) {
            nums[i] = 0;
        }
        for (; i < colorCount[0] + colorCount[1]; i++) {
            nums[i] = 1;
        }
        for (; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    public void sortColors(int[] nums) {
        //  2.可不可以一次遍历完事儿？ 3个元素分组->快排partition
        // 0元素索引位[0, zero]
        int zero = -1;
        // 2元素索引位[two, nums.length)
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 0) {
                swap(nums, zero + 1, i);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                assert nums[i] == 2;
                swap(nums, i, two - 1);
                two--;
            }
        }
    }

    /**
     * 88. 合并两个有序数组
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 临时空间保存nums元素
        int[] aux = new int[m];
        System.arraycopy(nums1, 0, aux, 0, m);
        // merge aux,nums2
        // 合并元素索引, aux待合并索引, nums2待合并索引位
        int i = 0, j = 0, k = 0;
        for (; i < m + n && j < m && k < n; i++) {
            if (aux[j] >= nums2[k]) {
                nums1[i] = nums2[k];
                k++;
            } else {
                nums1[i] = aux[j];
                j++;
            }
        }
        while (j < m) {
            nums1[i++] = aux[j++];
        }
        while (k < n) {
            nums1[i++] = nums2[k++];
        }
    }


    /**
     * 215. 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     */
    public int findKthLargest(int[] nums, int k) {
        int kIndex = nums.length - k;
        return findKth(nums, 0, nums.length - 1, kIndex);
    }

    /**
     * [l, r]中查找kIndex元素
     */
    private int findKth(int[] nums, int l, int r, int kIndex) {
        if (l >= r) {
            return nums[l];
        }
        int p = partition(nums, l, r);
        if (p == kIndex) {
            return nums[p];
        } else if (p < kIndex) {
            return findKth(nums, p + 1, r, kIndex);
        } else {
            return findKth(nums, l, p - 1, kIndex);
        }
    }

    /**
     * [l, r]中partition操作(标定点可采用随机优化)
     * 分组后元素所在索引
     */
    private int partition(int[] nums, int l, int r) {
        // 标定点
        int v = nums[l];
        // 待遍历索引, 大于目标[gt, r]
        int i = l + 1, gt = r + 1;
        while (i <= r && i < gt) {
            if (nums[i] > v) {
                gt--;
                swap(nums, i, gt);
            } else {
                i++;
            }
        }
        swap(nums, --i, l);
        return i;
    }


    private void swap(int[] arr, int sIndex, int tIndex) {
        int tmp = arr[sIndex];
        arr[sIndex] = arr[tIndex];
        arr[tIndex] = tmp;
    }


    public static void main(String[] args) {
        SolutionSort solution = new SolutionSort();
        int[] nums = ArrayUtils.genArray(20, 100);
        ArrayUtils.println(nums);
        System.out.println(solution.findKthLargest(nums, 3));
        SortUtils.mergeSort(nums);
        ArrayUtils.println(nums);
        // int[] nums = ArrayUtils.genArray(20, 2);
        // ArrayUtils.println(nums);
        // solution.sortColors(nums);
        // ArrayUtils.println(nums);
        // boolean sorted = ArrayUtils.isSorted(nums);
        // System.out.println(sorted);
    }


}
