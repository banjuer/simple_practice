package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListUtils;

import java.util.Stack;

public class Solution445 {

    /**
     * 445. 两数相加 II
     *
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 进阶：
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 两个链表分别放入两个栈中，然后分别弹栈相加，加入新链表
        Stack<Integer> s1 = list2Stack(l1);
        Stack<Integer> s2 = list2Stack(l2);

        // 进位标识
        int carry = 0;
        // 链表头部添加元素
        ListNode ans = null;
        while (!s1.empty() || !s2.empty() || carry != 0) {
            int e1 = s1.empty() ? 0 : s1.pop();
            int e2 = s2.empty() ? 0 : s2.pop();
            // 求和
            int sum = e1 + e2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else{
                carry = 0;
            }
            // 头部插入
            ListNode node = new ListNode(sum);
            node.next = ans;
            ans = node;
        }
        return ans;
    }

    private Stack<Integer> list2Stack(ListNode l) {
        Stack<Integer> s = new Stack<>();
        while (l != null){
            s.push(l.val);
            l = l.next;
        }
        return s;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtils.createLink(new int[]{7, 2, 4, 3});
        ListNode l2 = ListUtils.createLink(new int[]{5, 6, 4});
        Solution445 solution445 = new Solution445();
        ListUtils.println(solution445.addTwoNumbers(l1, l2));
    }

}
