package xyz.banjuer.common.utils;

import xyz.banjuer.common.entity.ListNode;

public class ListNodeUtils {

    public static ListNode createLink(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i = 0; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        return dummy.next;
    }

    public static void printLink(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append("->");
            head = head.next;
        }
        builder.append("NULL");
        System.out.println(builder);
    }

}
