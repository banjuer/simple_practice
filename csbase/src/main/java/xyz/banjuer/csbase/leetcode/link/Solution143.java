package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListNodeUtils;

public class Solution143 {

    /**
     * 143. 重排链表
     *
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reorder-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 找到中间位置后重新组合链表
        // 慢指针
        ListNode s = head;
        // 快指针
        ListNode q = head;
        // 1.使用快慢指针定位中间元素
        while (q.next != null && q.next.next != null) {
            s = s.next;
            q = q.next.next;
        }
        // 2.打断目标链表
        ListNode half = s.next;
        s.next = null;
        // 3.反转后半段
        ListNode halfCur = half;
        ListNode reversed = null;
        while (halfCur != null) {
            ListNode next = halfCur.next;
            halfCur.next = reversed;
            reversed = halfCur;
            halfCur = next;
        }
        half = reversed;
        // 4.重新排列
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            // 后半段链表到达尾部
            if (half == null) {
                cur = cur.next;
                continue;
            }
            cur.next = half;
            half = half.next;
            cur.next.next = next;
            cur = next;
        }
    }

    public void reorderList2(ListNode head) {
        // TODO
        // 方法2:
        // 1）使用数组保存所有节点信息
        // 2）数组首尾对撞指针创建新节点链表连接在head之后
    }

    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode link = ListNodeUtils.createLink(new int[]{1});
        solution143.reorderList(link);
        ListNodeUtils.printLink(link);
    }

}
