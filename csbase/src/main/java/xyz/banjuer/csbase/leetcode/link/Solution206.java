package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListNodeUtils;

public class Solution206 {

    /**
     * 206. 反转链表
     *
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public ListNode reverseList(ListNode head) {
        // 已反转的链表
        ListNode resvered = null;
        if (head == null) {
            return null;
        }
        while (head != null) {
            // 开始反转
            ListNode next = head.next;
            head.next = resvered;
            resvered = head;
            head = next;
        }
        return resvered;
    }

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode link = ListNodeUtils.createLink(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.printLink(solution206.reverseList(link));
    }

}
