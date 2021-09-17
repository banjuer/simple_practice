package xyz.banjuer.csbase.interview.top;

import xyz.banjuer.common.entity.ListNode;
import xyz.banjuer.common.utils.ListUtils;

import java.util.HashMap;
import java.util.Map;

public class Top10 {

    /**
     * ==========================================
     * 206.反转链表
     * =========================================
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        // 已反转的链表
        ListNode r = null;
        // 即将要反转的节点
        ListNode c = head;
        while (c != null) {
            ListNode n = c.next;
            c.next = r;
            r = c;
            c = n;
        }
        return r;
    }

    /**
     * ==========================================
     * 146.LRU设计
     * =========================================
     */
    class LRUCache {
        private int capacity;
        private CycleListNode head;
        private CycleListNode tail;
        private Map<Integer, CycleListNode> keyMap;

        public LRUCache(int capacity) {
            head = new CycleListNode();
            tail = new CycleListNode();
            head.next = tail;
            tail.pre = head;
            this.capacity = capacity;
            keyMap = new HashMap<>((int)(capacity/.75f) + 1);
        }

        public int get(int key) {
            CycleListNode node = keyMap.get(key);
            if (node == null) {
                return -1;
            }
            deleteNode(node);
            addToHead(node);
            return node.value;
        }

        private void addToHead(CycleListNode node) {
            CycleListNode next = head.next;
            head.next = node;
            node.next = next;
            next.pre = node;
            node.pre = head;
        }

        private void deleteNode(CycleListNode node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.pre = null;
            node.next = null;
        }

        public void put(int key, int value) {
            CycleListNode node = keyMap.get(key);
            if (node != null) {
                node.value = value;
                deleteNode(node);
                addToHead(node);
            } else {
                if (keyMap.size() == capacity) {
                    keyMap.remove(tail.pre.key);
                    deleteNode(tail.pre);
                }
                CycleListNode add = new CycleListNode();
                add.key = key;
                add.value = value;
                addToHead(add);
                keyMap.put(key, add);
            }
        }
    }

    class CycleListNode {
        CycleListNode pre;
        CycleListNode next;
        int value;
        int key;
    }


    /**
     * ==========================================
     * 3.无重复字符的最长子串
     * =========================================
     */

    public int lengthOfLongestSubstring(String s) {
        // TODO
        return -1;
    }

    public static void main(String[] args) {
        Top10 top10 = new Top10();
        ListNode head = ListUtils.createLink(new int[]{1,2,3,4,5});
        ListUtils.println(top10.reverseList(head));
    }

}
