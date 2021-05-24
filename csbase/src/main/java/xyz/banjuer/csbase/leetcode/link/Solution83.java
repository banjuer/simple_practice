package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListNodeUtils;

public class Solution83 {

    /**
     * 83. 删除排序链表中的重复元素
     *
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     * 返回同样按升序排列的结果链表。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // 当前节点与上一节点值相同时删除。每一个重复节点都只保留了第一个元素
        ListNode last = head;
        ListNode cur = last.next;
        while (cur != null) {
            // 当前节点值与上一节点值相同时，删除当前节点
            if (cur.val == last.val) {
                last.next = cur.next;
            } else {
                last = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution83 solution83 = new Solution83();
        ListNode link = ListNodeUtils.createLink(new int[]{1, 1, 2, 3, 3});
        ListNodeUtils.printLink(solution83.deleteDuplicates(link));
    }

}
