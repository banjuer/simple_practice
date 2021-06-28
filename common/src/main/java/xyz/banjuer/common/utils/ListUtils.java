package xyz.banjuer.common.utils;

import xyz.banjuer.common.entity.ListNode;

import java.util.Arrays;
import java.util.Random;

public class ListUtils {

    public static boolean isSorted(int[] arr) {
        if (arr.length == 1) return true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    public static int[] genSorted(int length, int max) {
        int[] arr = genArray(length, max);
        Arrays.sort(arr);
        return arr;
    }

    public static int[] genArray(int length, int max) {
        if (length < 0) throw new IllegalArgumentException("length must lager than " + length);
        int[] arr = new int[length];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max + 1);
        }
        return arr;
    }

    public static void println(Object[] arr) {
        if (arr == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i].toString());
            if (i != arr.length - 1) sb.append(',');
        }
        sb.append(']');
        System.out.println(sb);
    }

    public static void println(int[] arr) {
        if (arr == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(arr.length * 4);
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(", ");
        }
        sb.append(']');
        System.out.println(sb);
    }

    public static void swap(int[] arr, int sIndex, int tIndex) {
        int tmp = arr[sIndex];
        arr[sIndex] = arr[tIndex];
        arr[tIndex] = tmp;
    }

    public static ListNode createLink(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i = 0; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        return dummy.next;
    }

    public static void println(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append("->");
            head = head.next;
        }
        builder.append("NULL");
        System.out.println(builder);
    }

}
