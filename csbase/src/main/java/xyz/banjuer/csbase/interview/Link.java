package xyz.banjuer.csbase.interview;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListNodeUtils;

public class Link {

    public ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode reversed = node;
        ListNode cur = node.next;
        reversed.next = null;

        ListNode next;
        while (cur != null) {
            next = cur.next;
            if (next == null) {
                cur.next = reversed;
                reversed = cur;
                return reversed;
            }
            cur.next = reversed;
            reversed = cur;
            cur = next;
        }
        return reversed;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.createLink(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.printLink(head);
        Link link = new Link();
        ListNodeUtils.printLink(link.reverse(head));
    }

}
