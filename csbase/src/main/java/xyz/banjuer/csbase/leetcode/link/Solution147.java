package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListUtils;

public class Solution147 {

    /**
     * 147. 对链表进行插入排序
     *
     * 插入排序算法：
     * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 重复直到所有输入数据插入完为止。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/insertion-sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 考虑到已排序链表可能在任意位置(头部)插入，引入虚拟头结点
        // 已排序
        ListNode dummy = new ListNode();
        // 1)遍历未排序，依次取出所有节点
        while (head != null) {
            // 保存下一个遍历节点
            ListNode next = head.next;
            // 2)插入到已排序链表合适位置
            ListNode pre = dummy;
            // 定位到第一个大于当前元素的位置，插入元素则在cur之前，pre之后
            ListNode cur = pre.next;
            while (cur != null && cur.val <= head.val) {
                pre = cur;
                cur = cur.next;
            }
            // 插入pre之后cur之前
            pre.next = head;
            head.next = cur;
            head = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution147 solution147 = new Solution147();
        ListNode link = ListUtils.createLink(ListUtils.genArray(10, 100));
        ListUtils.println(link);
        ListUtils.println(solution147.insertionSortList(link));
    }

}
