package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListNodeUtils;

public class Solution82 {

    /**
     * 82. 删除排序链表中的重复元素 II
     *
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 返回同样按升序排列的结果链表。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        // 当前值与下一值相同时,删除当前节点并标记下一节点应该删除(下一循环)
        boolean delNext = false;
        while (head != null) {
            if (head.next != null) {
                // 当前节点值与下一节点值相同时，删除当前节点并标记下一节点应该删除
                if (head.next.val == head.val) {
                    pre.next = head.next;
                    head = head.next;
                    delNext = true;
                    continue;
                }
            }
            // 当节点应该删除时(重复的最后一个节点)，删除当前节点
            if (delNext) {
                pre.next = head.next;
                delNext = false;
            } else {
                // 不删除时,移动前置节点为当前
                pre = head;
            }
            head = head.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        Solution82 solution82 = new Solution82();
        ListNode link = ListNodeUtils.createLink(new int[]{1, 1, 1, 2, 3});
        ListNodeUtils.printLink(solution82.deleteDuplicates(link));
    }

}
