package xyz.banjuer.csbase.leetcode.link;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListUtils;

import java.util.Stack;

public class Solution234 {

    /**
     * 234. 回文链表
     *
     * 请判断一个链表是否为回文链表。
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     */
    public boolean isPalindromeN(ListNode head) {
        // 其他思路: 链表copy到数组中，然后数组头尾互撞
        // 使用On空间复杂度
        // 第一遍遍历所有数据保存一遍
        // 再次从头遍历，弹栈比较当不同时false
        // 1.节点入栈
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        // 2.依次出栈
        cur = head;
        while (cur != null) {
            Integer pop = stack.pop();
            if (cur.val != pop) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        // O1空间复杂度
        // 1. 定位到链表中间位置:1).遍历 2).快慢指针(快指针到头，慢指针到中间。什么是中间？)
        // 2. 打断链表，并反转前半部链表
        // 3. 依次比较两段链表
        // 4. 还原链表
        return false;
    }

    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();
        ListNode link = ListUtils.createLink(new int[]{1});
        System.out.println(solution234.isPalindromeN(link));
    }

}
