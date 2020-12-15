package xyz.banjuer.common.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author banjuer
 * Remark: 近乎所有排序算法在元素小于一定程度时可使用插入排序进行优化
 */
public class SortUtils {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    /**
     * 冒泡
     */
    public static void bubbleSort(int[] arr) {
        // 已排序元素
        int sz = 0;
        while (sz < arr.length) {
            for (int i = 0; i < arr.length - sz; i++) {
                if (i + 1 < arr.length -sz && arr[i] > arr[i + 1])
                    swap(arr, i, i+1);
            }
            sz++;
        }
    }

    /**
     * 1. 快排
     */
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
     * 2.1 自底向上
     */
    public static void mergeSortBU(int[] arr) {
        for (int sz = 1; sz <= arr.length; sz += sz) {
            for (int i = 0; i + sz < arr.length; i += sz + sz) {
                merge(arr, i, i + sz, Math.min(i + sz + sz, arr.length));
            }
        }
    }

    /**
     * 2.2 递归归并: 自顶向下
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

    /**
     * 3. 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr) {
        // 使用大顶堆，维护sz，实现不需额外空间
        heapfiy(arr);
        int sz = arr.length;
        while (sz > 1) {
            swap(arr, 0, --sz);
            siftDown(arr, 0, sz);
        }
    }

    /**
     * 倒数第一个有叶子节点元素向前依次下沉
     */
    private static void heapfiy(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
    }

    /**
     * 大顶堆
     * [0, sz)区间i元素下沉
     */
    private static void siftDown(int[] arr, int i, int sz) {
        int l = i * 2 + 1;
        while (l < sz) {
            int r = l + 1, max = l;
            if (r < sz && arr[r] > arr[l]) max = r;
            if (arr[i] < arr[max]) swap(arr, i, max);
            i = max;
            l = i * 2 + 1;
        }
    }

    private static class MinHeap {
        private int sz;
        private int[] arr;

        public boolean isEmpty() {
            return this.sz == 0;
        }

        public MinHeap(int[]  arr) {
            this.sz = arr.length;
            this.arr = new int[sz];
            System.arraycopy(arr, 0, this.arr, 0, sz);
            heapfiy();
        }

        private void heapfiy() {
            for (int i = parent(this.sz - 1); i >= 0; i--) {
                siftDown(i);
            }
        }

        public int extract() {
            if (this.sz == 0) throw new RuntimeException("no element to pop");
            int min = this.arr[0];
            swap(this.arr, 0, --this.sz);
            siftDown(0);
            return min;
        }

        /**
         * 元素下沉
         */
        private void siftDown(int index) {
            int l = left(index);
            while (l < this.sz) {
                int min = l, r = l + 1;
                if (r < this.sz && arr[r] < arr[l]) min = r;
                if (arr[index] > arr[min]) {
                    swap(arr, min, index);
                }
                index = min;
                l = left(index);
            }
        }

        private int left(int index) {
            return index * 2 + 1;
        }

        private int right(int index) {
            return (index + 1) * 2;
        }

        private int parent(int index) {
            // index左侧元素索引 = index - 1
            return (index - 1) / 2;
        }

    }

    private static void swap(int[] arr, int s, int t) {
        int tmp = arr[s];
        arr[s] = arr[t];
        arr[t] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtils.genArray(20, 1000);
        // int[] nums = new int[]{11, 57, 92, 58, 50, 4, 68, 47, 60, 49};
        long start = System.currentTimeMillis();
        ArrayUtils.println(nums);
        // quickSort(nums);
        // heapSort(nums);
        bubbleSort(nums);
        ArrayUtils.println(nums);
        long end = System.currentTimeMillis();
        System.out.printf("is sorted: %s, cost: %fs\n", ArrayUtils.isSorted(nums), (end - start)/1000.0);
    }

}
