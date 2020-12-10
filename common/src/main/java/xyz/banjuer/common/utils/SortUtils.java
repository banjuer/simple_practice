package xyz.banjuer.common.utils;

/**
 * @author banjuer
 * Remark: 近乎所有排序算法在元素小于一定程度时可使用插入排序进行优化
 */
public class SortUtils {

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
        int[] nums = ArrayUtils.genArray(10, 20);
        ArrayUtils.println(nums);
        System.out.println("is sorted:" + ArrayUtils.isSorted(nums));
        // SortUtils.mergeSort(nums);
        SortUtils.mergeSortBU(nums);
        ArrayUtils.println(nums);
        System.out.println("is sorted:" + ArrayUtils.isSorted(nums));
    }

}
