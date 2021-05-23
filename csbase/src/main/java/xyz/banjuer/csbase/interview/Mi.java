package xyz.banjuer.csbase.interview;

import xyz.banjuer.common.utils.ArrayUtils;

public class Mi {

    public static void main(String[] args) {
        int[] a1 = {0};
        int[] a2 = {1};
        // int[] a1 = {0, 2, 4, 6, 0, 0, 0};
        // int[] a2 = {1,2,3};
        merge(a1, 0, a2, 1);
        ArrayUtils.println(a1);
    }

    public static void merge(int A[], int m, int B[], int n) {
        int[] aTmp = new int[m];
        System.arraycopy(A, 0, aTmp, 0, aTmp.length);

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            int a = aTmp[i];
            int b = B[j];
            int t;
            if (a <= b) {
                t = a;
                i++;
            } else {
                t = b;
                j++;
            }
            A[k] = t;
            k++;
        }

        while (i < m) {
            A[k++] = aTmp[i++];
        }
        while (j < n) {
            A[k++] = B[j++];
        }
    }

}
