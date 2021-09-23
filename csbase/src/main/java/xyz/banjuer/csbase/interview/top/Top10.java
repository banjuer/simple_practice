package xyz.banjuer.csbase.interview.top;

import xyz.banjuer.common.entity.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charIndex = new HashMap<>((int)(s.length()/.75f) + 1);
        char[] chars = s.toCharArray();
        int max = 0;
        // 遍历过程中维护[l,r]无重复序列
        int l;
        for (int r = 0; r < chars.length; r++) {
            Integer index = charIndex.get(chars[r]);
            // 即将发生重复字符串
            if (index != null) {
                max = Math.max(max, charIndex.size());
                charIndex.clear();
                // 不重复序列从开始重复的下一位置开始
                l = index + 1;
                for (int i = l; i <= r; i++) {
                    charIndex.put(chars[i], i);
                }
            } else {
                charIndex.put(chars[r], r);
            }
        }
        return Math.max(max, charIndex.size());
    }


    /**
     * ==========================================
     * 215. 数组中的第K个最大元素
     * =========================================
     */
    public int findKthLargest(int[] nums, int k) {
        assert nums != null && nums.length >= k;
        int l = 0, r = nums.length - 1;
        k = nums.length - k;
        while (true) {
            int p = partition(nums, l, r);
            if (p > k) {
                r = p - 1;
            } else if (p < k) {
                l = p + 1;
            } else {
                return nums[p];
            }
        }
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        // [l + 1, le] <= v, (le, i) > v
        int le = l, i = l + 1;
        while (i <= r) {
            if (nums[i] <= v) {
                swap(nums, le + 1, i);
                le ++;
            }
            i++;
        }
        swap(nums, l, le);
        return le;
    }

    private void swap(int[] arr, int s, int t) {
        int temp = arr[s];
        arr[s] = arr[t];
        arr[t] = temp;
    }

    /**
     * ==========================================
     * 25. K 个一组翻转链表
     * =========================================
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 先计算长度，得出反转段
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        assert k <= len && len > 0;
        ListNode dummy = new ListNode(0);
        ListNode done = dummy;
        cur = head;
        Stack<ListNode> stack = new Stack<>();
        for (int i = 1; i <= len / k; i++) {
            for (int j = 0; j < k; j++) {
                stack.push(cur);
                cur = cur.next;
            }
            while (!stack.isEmpty()) {
                ListNode pop = stack.pop();
                pop.next = null;
                done.next = pop;
                done = done.next;
            }
        }
        while (cur != null) {
            done.next = cur;
            cur = cur.next;
            done = done.next;
        }
        return dummy.next;
    }

    /**
     * ==========================================
     * 912. 排序数组
     * =========================================
     */
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        quick(nums, 0, nums.length - 1);
        return nums;
    }

    private void quick(int[] nums, int l, int r) {
        if (r <= l) return;
        int p = partition(nums, l, r);
        quick(nums, l, p - 1);
        quick(nums, p + 1, r);
    }


    public static void main(String[] args) {
        Top10 top10 = new Top10();
        // ListNode head = ListUtils.createLink(new int[]{1,2,3,4,5});
        // ListUtils.println(top10.reverseList(head));
        // System.out.println(top10.lengthOfLongestSubstring(" "));
        int kthLargest = top10.findKthLargest(new int[]{1, 3, 2, 4, 7, 5, 6}, 3);
        System.out.println(kthLargest);
    }

}
