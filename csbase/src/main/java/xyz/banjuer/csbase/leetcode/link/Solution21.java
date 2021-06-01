package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;

public class Solution21 {

    /**
     * 21. 合并两个有序链表
     *
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode merged = dummy;

        while (l1 != null && l2 != null) {
            int _1 = l1.val;
            int _2 = l2.val;
            if (_1 >= _2) {
                merged.next = l2;
                l2 = l2.next;
            } else {
                merged.next = l1;
                l1 = l1.next;
            }
            merged = merged.next;
        }
        while (l1 != null) {
            merged.next = l1;
            merged = merged.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            merged.next = l2;
            merged = merged.next;
            l2 = l2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        ListNode l1 = ListUtils.createLink(new int[]{});
        ListNode l2 = ListUtils.createLink(new int[]{});
        ListNode merged = solution21.mergeTwoLists(l1, l2);
        ListUtils.printLink(merged);
    }


}
