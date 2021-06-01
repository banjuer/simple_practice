package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;

public class Solution328 {

    /**
     * 328. 奇偶链表
     *
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     *
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode oddEvenList(ListNode head) {
        // 使用两个链表保存odd，even链表,以及两个移动链表节点
        int index = 1;
        // 奇链表
        ListNode odd = new ListNode();
        ListNode oddCur = odd;
        // 偶链表
        ListNode even = new ListNode();
        ListNode evenCur = even;
        while (head != null) {
            ListNode next = head.next;
            if ((index & 1) == 1) {
                oddCur.next = head;
                oddCur = oddCur.next;
            } else {
                evenCur.next = head;
                evenCur = evenCur.next;
            }
            head.next = null;
            head = next;
            index++;
        }
        oddCur.next = even.next;
        even.next = null;
        return odd.next;
    }

    public static void main(String[] args) {
        ListNode link = ListUtils.createLink(new int[]{1,2,3,4});
        Solution328 solution328 = new Solution328();
        ListUtils.printLink(solution328.oddEvenList(link));
    }

}
