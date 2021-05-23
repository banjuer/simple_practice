package xyz.banjuer.common.utils;

import xyz.banjuer.common.enty.Node;

public class LinkUtils {

    public static Node genLink(int[] arr) {
        Node dummy = new Node(0);
        Node head = dummy;
        for (int i = 0; i < arr.length; i++) {
            head.next = new Node(arr[i]);
            head = head.next;
        }
        return dummy.next;
    }

    public static void printLink(Node head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.data).append("->");
            head = head.next;
        }
        builder.append("NULL");
        System.out.println(builder);
    }

}
