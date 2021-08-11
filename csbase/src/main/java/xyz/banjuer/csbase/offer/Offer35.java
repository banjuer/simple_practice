package xyz.banjuer.csbase.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 使用hash表保留所有已创建节点, key为原节点
    Map<Node, Node> created = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(-1);
        Node cur = dummy;
        while (head != null) {
            Node copy = copyNode(head);
            copy.next = copyNode(head.next);
            copy.random = copyNode(head.random);
            cur.next = copy;
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }

    private Node copyNode(Node source) {
        if (source == null) {
            return null;
        }
        Node copy = created.get(source);
        if (copy == null) {
            copy = new Node(source.val);
            created.put(source, copy);
        }
        return copy;
    }
}
