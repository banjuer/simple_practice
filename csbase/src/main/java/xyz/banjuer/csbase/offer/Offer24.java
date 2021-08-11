package xyz.banjuer.csbase.offer;

import xyz.banjuer.common.entity.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Offer24 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reversed, cur, next;
        reversed = head;
        cur = reversed.next;
        reversed.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = reversed;
            reversed = cur;
            cur = next;
        }
        return reversed;
    }

}
