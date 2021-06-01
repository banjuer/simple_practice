package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;

public class Solution86 {

    /**
     * 86. 分隔链表
     *
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode partition(ListNode head, int x) {
        // 保存两个链表，分别代表大于等于x和小于x的链表，随后将小链表的尾部指向大链表即可
        ListNode small = new ListNode();
        ListNode large = new ListNode();

        ListNode smallTail = small;
        ListNode largeTail = large;
        while (head != null) {
            if (head.val >= x) {
                largeTail.next = head;
                largeTail = largeTail.next;
                head = head.next;
                // 当前尾部节点需指向空
                largeTail.next = null;
            } else {
                smallTail.next = head;
                smallTail = smallTail.next;
                head = head.next;
                smallTail.next = null;
            }

        }
        smallTail.next = large.next;
        return small.next;
    }

    public static void main(String[] args) {
        Solution86 solution86 = new Solution86();
        ListNode link = ListUtils.createLink(new int[]{1, 4, 3, 2, 5, 2});
        ListUtils.printLink(solution86.partition(link, 3));
    }

}
