package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListNodeUtils;

public class Solution92 {

    /**
     * 92. 反转链表 II
     *
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 以及一个遍历的节点:curNode
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curNode = dummy;
        // 需要定位5个节点：当前链表的头head，left的前一个节点preLeftNode,left节点leftNode,right节点rightNode，right下一个几点afterRightNode
        ListNode preLeftNode = null, leftNode, rightNode,afterRightNode;
        // 定位5个节点
        int index = 0;
        // left<1从头反转
        if (left < 1) {
            left = 1;
        }
        // 定位到left上一个节点
        while (index < left) {
            preLeftNode = curNode;
            curNode = curNode.next;
            index++;
        }
        leftNode = preLeftNode.next;
        // 此时index已经到达left,定位right节点
        while (index < right) {
            curNode = curNode.next;
            index++;
        }
        rightNode = curNode;
        afterRightNode = rightNode.next;
        // 打断
        preLeftNode.next = null;
        rightNode.next = null;
        // 反转链表
        ListNode reversed = null, cur2 = leftNode;
        while (cur2 != null) {
            ListNode next = cur2.next;
            cur2.next = reversed;
            reversed = cur2;
            cur2 = next;
        }
        // 拼接最后链表
        preLeftNode.next = rightNode;
        leftNode.next = afterRightNode;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution92 solution92 = new Solution92();
        ListNode link = ListNodeUtils.createLink(new int[]{1, 2, 3, 4, 5, 6});
        ListNodeUtils.printLink(solution92.reverseBetween(link, 1, 6));
    }

}
