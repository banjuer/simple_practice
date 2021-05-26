package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListNodeUtils;

public class Solution203 {

    /**
     * 203. 移除链表元素
     *
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     */
    public ListNode removeElements(ListNode head, int val) {
        // 考虑头结点的变更使用虚拟头结点
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        dummy.next = head;

        while (head != null) {
            ListNode next = head.next;
            if (head.val == val) {
                pre.next = next;
            } else {
                pre = head;
            }
            head = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution203 solution203 = new Solution203();
        ListNode link = ListNodeUtils.createLink(new int[]{1, 1, 1,1});
        ListNodeUtils.printLink(solution203.removeElements(link, 1));
    }

}
