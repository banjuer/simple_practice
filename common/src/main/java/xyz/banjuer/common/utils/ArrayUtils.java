package xyz.banjuer.common.utils;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    public static int[] genSorted(int length, int max) {
        if (length < 0) throw new IllegalArgumentException("length must lager than " + length);
        int[] arr = new int[length];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max + 1);
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void println(int[] arr) {
        StringBuilder sb = new StringBuilder(arr.length * 4);
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(", ");
        }
        sb.append(']');
        System.out.println(sb.toString());
    }

    public static void swap(int[] arr, int sIndex, int tIndex) {
        int tmp = arr[sIndex];
        arr[sIndex] = arr[tIndex];
        arr[tIndex] = tmp;
    }

    public static void main(String[] args) {
        int[] sorted = ArrayUtils.genSorted(10, 100);
        ArrayUtils.println(sorted);
        ArrayUtils.swap(sorted, 1, 2);
        ArrayUtils.println(sorted);
    }

}
