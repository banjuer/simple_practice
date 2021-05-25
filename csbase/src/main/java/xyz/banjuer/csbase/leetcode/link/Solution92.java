package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;

public class Solution92 {

    /**
     * 92. 反转链表 II
     *
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 遍历的索引位
        int index = 1;
        ListNode beforeLeft = null;
        while (index < left) {
            beforeLeft = head;
            head = head.next;
            index ++;
        }
        // 此时 index == left
        beforeLeft.next = null;
        // 开始反转链表
        ListNode pre = null;
        ListNode lNode = head;
        ListNode next = head.next;
        while (index <= right) {
            head.next = pre;
            pre = head;
            next = head.next;
        }
        ListNode rNode = next;

        beforeLeft.next = rNode;
        lNode.next = head.next;
        return dummy.next;
    }

}
