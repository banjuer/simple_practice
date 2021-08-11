package xyz.banjuer.csbase.offer;

import xyz.banjuer.common.entity.ListNode;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Offer06 {

    public int[] reversePrint(ListNode head) {
        // 计算链表大小
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        // 从数组尾部向前依次插入链表值
        int[] result = new int[size];
        if (size > 0) {
            int index = size - 1;
            while (head != null) {
                result[index] = head.val;
                index --;
                head = head.next;
            }
        }
        return result;
    }

}
