package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;

public class Solution237 {

    /**
     * 237. 删除链表中的节点
     *
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     */
    public void deleteNode(ListNode node) {
        // 由于删除节点需要节点的前一节点，此时没有前节点故可能需要修改节点值
        // 把后续节点值更新到当前节点并删除后续节点
        // 1.更新节点值
        ListNode next = node.next;
        node.val = next.val;
        // 2.删除后续节点
        node.next = next.next;
    }

}
