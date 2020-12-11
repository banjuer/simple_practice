package xyz.banjuer.common.utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author banjuer
 * Remark: 近乎所有排序算法在元素小于一定程度时可使用插入排序进行优化
 */
public class SortUtils {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * [l, r]区间快排
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    /**
     * [l, r]
     * partition后元素放置到正确坐标并返回坐标
     */
    private static int partition(int[] arr, int l, int r) {
        // 随机标定点
        int t = RANDOM.nextInt(l, r + 1);
        ArrayUtils.swap(arr, l, t);
        int v = arr[l];
        // 待遍历索引, 小于v [l + 1, lt], 大于v[gt, r], 等于v[lt + 1, i)
        int i = l, lt = l, gt = r + 1;
        while (i <= r && i < gt) {
            if (arr[i] == v)
                i++;
            else if (arr[i] > v) {
                gt--;
                ArrayUtils.swap(arr, gt, i);
            } else {
                lt++;
                ArrayUtils.swap(arr, lt, i);
                i++;
            }
        }
        int index = i - 1;
        ArrayUtils.swap(arr, l, index);
        return index;
    }

    /**
     * 自底向上
     */
    public static void mergeSortBU(int[] arr) {
        for (int sz = 1; sz <= arr.length; sz += sz) {
            for (int i = 0; i + sz < arr.length; i += sz + sz) {
                merge(arr, i, i + sz, Math.min(i + sz + sz, arr.length));
            }
        }
    }

    /**
     * 递归归并: 自顶向下
     */
    public static void mergeSort(int[] arr) {
       mergeSort(arr, 0, arr.length);
    }

    /**
     * [l, r) 归并排序
     */
    private static void mergeSort(int[] arr, int l, int r) {
        // 剩余少于最后一个元素则递归截止
        if (l + 1 >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid, r);
        merge(arr, l, mid, r);
    }

    /**
     * [l,r)区间
     * 归并[l,m),[m,r)元素
     */
    private static void merge(int[] arr, int l, int m, int r) {
        int[] aux = new int[r -l];
        // 归并后索引位
        int i = 0;
        // 左边起始[l, m) 左侧下一个待遍历索引位
        int j = l;
        // 右边起始[m, r) 右侧下一个待遍历索引位
        int k = m;
        for (; i < aux.length && j < m && k < r; i++) {
            // 左边相等优先放置
            if (arr[j] <= arr[k]) {
                aux[i] = arr[j];
                j++;
            } else {
                aux[i] = arr[k];
                k++;
            }
        }
        while (j < m) {
            aux[i++] = arr[j++];
        }
        while (k < r) {
            aux[i++] = arr[k++];
        }
        for (int value : aux) {
            arr[l++] = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtils.genArray(2000000, 10000);
        long start = System.currentTimeMillis();
        // ArrayUtils.println(nums);
        quickSort(nums);
        Arrays.sort(nums);
        // ArrayUtils.println(nums);
        long end = System.currentTimeMillis();
        System.out.printf("is sorted: %s, cost: %fs\n", ArrayUtils.isSorted(nums), (end - start)/1000.0);
    }

}
