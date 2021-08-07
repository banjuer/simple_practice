package xyz.banjuer.csbase.interview;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListUtils;

public class Trick {

    /**
     * 100个人手牵手，报偶数留下，最后一个人的序号
     */
    public static ListNode theLast(ListNode root, int total) {
        ListNode cur = root;
        while (total != 1) {
            // 下一个节点为当前节点的下一个的下一个
            cur.next = cur.next.next;
            cur = cur.next;
            total--;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 1; i <= 100; i++) {
            arr[i-1] = i;
        }
        ListNode root = ListUtils.createLink(arr);
        ListNode tail = root;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = root;
        ListNode last = theLast(root, 100);
        System.out.println(last.val);
    }

}
