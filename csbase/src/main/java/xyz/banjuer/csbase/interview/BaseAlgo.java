package xyz.banjuer.csbase.interview;

import xyz.banjuer.common.utils.ListUtils;

import static xyz.banjuer.common.utils.ListUtils.swap;

public class BaseAlgo {

    public static void heapSort(int[] arr) {

    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        qs(arr, 0, arr.length - 1);
    }

    private static void qs(int[] arr, int l, int r) {
        if (r <= l) return;
        int p = partition(arr, l, r);
        qs(arr, l, p - 1);
        qs(arr, p + 1, r);
    }


    /**
     * 对arr[l]分区，分区后arr[l]在合适的位置并返回其坐标
     */
    private static int partition(int[] arr, int l, int r) {
        int e = arr[l];
        // [l + 1, le] < e, [le + 1, i - 1] >= e
        int le = l, i = l + 1;
        while (i <= r) {
            if (arr[i] < e) {
                swap(arr, i, le + 1);
                le++;
            }
            i++;
        }
        // 此时l应与le交换。l占据一个索引位，[l,le]<e [le+1,r]>=e
        swap(arr, l, le);
        return le;
    }

    public static void main(String[] args) {
        int[] arr = ListUtils.genArray(100, 100);
        System.out.println(ListUtils.isSorted(arr));
        quickSort(arr);
        System.out.println(ListUtils.isSorted(arr));
    }

}
