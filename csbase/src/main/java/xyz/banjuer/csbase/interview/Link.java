package xyz.banjuer.csbase.interview;

import xyz.banjuer.common.enty.Node;
import xyz.banjuer.common.utils.LinkUtils;

public class Link {

    public Node reverse(Node node) {
        if (node == null) {
            return null;
        }
        Node reversed = node;
        Node cur = node.next;
        reversed.next = null;

        Node next;
        while (cur != null) {
            next = cur.next;
            if (next == null) {
                cur.next = reversed;
                reversed = cur;
                return reversed;
            }
            cur.next = reversed;
            reversed = cur;
            cur = next;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Node head = LinkUtils.genLink(new int[]{1, 2, 3, 4, 5});
        LinkUtils.printLink(head);
        Link link = new Link();
        LinkUtils.printLink(link.reverse(head));
    }

}
