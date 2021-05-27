package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListNodeUtils;

public class Solution24 {

    /**
     * 24. 两两交换链表中的节点
     *
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 使用四个指针分别保存交换链表和奇前后节点
        ListNode pre = dummy;
        ListNode next = head.next;
        // 循环截止，至少要交换的两个节点不能为空
        while (next != null) {
            ListNode afterNext = next.next;
            // 交换节点
            pre.next = next;
            next.next = head;
            head.next = afterNext;
            // 移动链表
            pre = head;
            head = afterNext;
            if (head == null) {
                break;
            }
            next = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode link = ListNodeUtils.createLink(new int[]{1, 2, 3, 4,5});
        ListNodeUtils.printLink(solution24.swapPairs(link));
    }

}
