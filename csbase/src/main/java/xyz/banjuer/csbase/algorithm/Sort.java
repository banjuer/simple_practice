package xyz.banjuer.csbase.algorithm;

import xyz.banjuer.common.utils.ListUtils;


public class Sort {

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // [i, arr.length)选择最小元素与i交换
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public void insert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将第i个元素插入到[0, i - 1]中合适的位置
            // i向前依次与每一个元素相比，小于则交换位置，交换后比较索引为上次交换后位置
            int compareIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[compareIndex] < arr[j]) {
                    swap(arr, compareIndex, j);
                    compareIndex = j;
                }
            }
        }
    }

    public void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 第i个一次和后面每个元素比较，大于则与i交换
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);

                }
            }
        }
    }

    public void merge(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    /**
     * [l, r]内进行归并排序
     */
    private void merge(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (r - l) / 2 + l;
        merge(arr, l, m);
        merge(arr, m + 1, r);
        int[] temp = new int[r - l + 1];
        // [l,m], [m+1,r]合并
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= m) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, l, temp.length);
    }

    public void quick(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    /**
     * [l, r] 快排
     */
    private void quick(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quick(arr, l, p - 1);
        quick(arr, p + 1, r);
    }

    /**
     * 把标定点元素arr[l]分区，返回arr[l]正确的位置
     */
    private int partition(int[] arr, int l, int r) {
        // 标定元素
        int v = arr[l];
        // 分区完毕后v应在的索引位 [l+1, j]<v, [j+1,r]>=v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public void heap(int[] arr) {
        // 从第一个非叶子节点开始，行程一个最大堆
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            siftDown(arr, arr.length - 1, i);

        // 从第一个元素开始，堆最大值与最后交换
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            // 最后一个元素已经形成，右边接i - 1
            siftDown(arr, i - 1, 0);
        }
    }

    private void siftDown(int[] arr, int r, int i) {
        // 左孩子不越界,肯定有子节点
        while (i * 2 + 1 <= r) {
            // 交换节点
            int j = i * 2 + 1;
            if (j + 1 <= r && arr[j] < arr[j + 1])
                j = j + 1;
            if (arr[j] > arr[i])
                swap(arr, i, j);
            else
                break;
            i = j;
        }
    }

    private int left(int i) {
        return i * 2 + 1;
    }

    private int right(int i) {
        return (i + 1) * 2;
    }

    private int parent(int i) {
        int p = (i - 1) / 2;
        return Math.max(p, 0);
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        // int[] arr = ListUtils.genArray(1000000, Integer.MAX_VALUE - 1);
        int[] arr = ListUtils.genArray(10, 100);
        ListUtils.println(arr);
        sort.heap(arr);
        ListUtils.println(arr);
        System.out.println(ListUtils.isSorted(arr));
    }

}
