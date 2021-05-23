package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListNodeUtils;

public class Solution2 {


    /**
     * 2. 两数相加
     *
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 返回的链表的虚拟头部
        ListNode dummy = new ListNode();
        // 求和后链表节点
        ListNode append = dummy;
        // 进位标识
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if(sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            append.next = new ListNode(sum);
            append = append.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 补充剩余链表
        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            append.next = new ListNode(sum);
            append = append.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            append.next = new ListNode(sum);
            append = append.next;
            l2 = l2.next;
        }
        // 链表遍历完毕后，进位>0则添加
        if (carry == 1) {
            append.next = new ListNode(1);
        }
        return dummy.next;
    }

    /**
     * 逻辑优化
     * l1,l2与补充结果统一逻辑: 当长度不够时的链表需拟出一个节点
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        // 已求和的节点位置
        ListNode summed = dummy;
        // 进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int _1 = l1 == null ? 0 : l1.val;
            int _2 = l2 == null ? 0 : l2.val;
            int sum = _1 + _2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            summed.next = new ListNode(sum);
            summed = summed.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            summed.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.createLink(new int[]{9,9,9,9,9,9,9});
        ListNode l2 = ListNodeUtils.createLink(new int[]{9, 9, 9, 9});
        Solution2 solution2 = new Solution2();
        ListNode listNode = solution2.addTwoNumbers2(l1, l2);
        ListNodeUtils.printLink(listNode);
    }

}
