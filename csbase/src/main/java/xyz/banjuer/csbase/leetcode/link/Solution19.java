package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;

public class Solution19 {

    /**
     * 19. 删除链表的倒数第 N 个结点
     *
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 进阶：你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 使用双指针，两个指针的间隔即为n，当第二个指针走到尾部null时，第一个指针到达删除节点的上一个节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 目标上一节点
        ListNode p = dummy;
        // 间隔尾部节点
        ListNode q = dummy;
        for (int i = 0; i <= n; i++) {
            q = q.next;
        }
        // 到达目标上一节点
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        ListNode delNode = p.next;
        p.next = delNode.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 两趟扫描，因涉及可能删除头结点故需使用虚拟头，index从0（虚拟头节点）开始
        // 第一趟：记录总长度，得出要删除节点的前一个索引；第二趟遍历走到目标节点删除下一节点
        // 1.记录链表总长度
        ListNode dummy = new ListNode();
        dummy.next = head;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        // 待删除节点的上一节点index
        int p = len - n;
        int index = 0;
        cur = dummy;
        while (index < p) {
            cur = cur.next;
            index ++;
        }
        // 删除下一节点
        ListNode delNode = cur.next;
        cur.next = delNode.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        ListNode link = ListUtils.createLink(new int[]{1, 2, 3, 4, 5, 6});
        ListUtils.printLink(solution19.removeNthFromEnd(link, 1));
    }

}
