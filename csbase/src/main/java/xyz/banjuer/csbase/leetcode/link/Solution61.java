package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;

public class Solution61 {

    /**
     * 61. 旋转链表
     *
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     */
    public ListNode rotateRight(ListNode head, int k) {
        // 其他思路：链表闭合为环后处理
        // 找到倒数第k个元素的上一节点, 打断链表，然后链接第一段。注：因k可能大于链表长度故需要先对k求模
        if (head == null || k < 1) {
            return head;
        }
        // 1. 对k取模
        int len = 0;
        ListNode cur = head;
        ListNode tail = null;
        while (cur!=null) {
            tail = cur;
            cur = cur.next;
            len++;
        }
        k = k % len;
        // 整圈的直接返回
        if(k == 0) {
            return head;
        }
        // 2. 定位倒数第k上一个元素index
        int p = len - k;
        cur = head;
        for (int i = 1; i < p; i++) {
            cur = cur.next;
        }
        // 3. 打断链表
        ListNode retNode = cur.next;
        cur.next = null;
        tail.next = head;
        return retNode;
    }

    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        ListNode link = ListUtils.createLink(new int[]{1});
        ListUtils.printLink(solution61.rotateRight(link, 1));
    }

}
