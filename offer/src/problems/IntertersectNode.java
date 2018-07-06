/**
 * 得到两链表第一个相交节点（假如有）：主要是链表有环问题（基本上是最难的链表题了）:看文档了，不写这里，太长了
 */
package problems;

import java.util.HashSet;

public class IntertersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getIntersectNode (Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null)
            return noloop(head1, head2);
        if (loop1 != null && loop2 != null)
            return bothLoop(head1, head2, loop1, loop2);
        return null;
    }

    public static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 != loop2) {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2)
                    return loop1;
                cur1 = cur1.next;
            }
            return null;
        }

//        while (cur1 != loop1)   不建议这样做，因为可能会修改表结构
//            cur1 = cur1.next;
//        cur1.next = null;
//
////        while (cur2 != loop2)  上一步应该就已经砍掉环了，应该最后节点是相同的
////            cur2 = cur2.next;
////        cur2.next = null;
        cur1 = head1;
        cur2 = head2;
        int len = 0;
        while (cur1 != loop1) {
            len++;
            cur1 = cur1.next;
        }
        while (cur2 != loop2) {
            len--;
            cur2 = cur2.next;
        }
        cur1 = len > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        len = Math.abs(len);
        while (len != 0) {
            len--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node getLoopNode(Node head) {
        if (head == null)
            return head;

//        HashSet<Node> set = new HashSet<>();  hashSet方法
//        while (head != null){
//            if (!set.add(head))
//                return head;
//            head = head.next;
//        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static Node noloop(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

//        HashSet<Node> set = new HashSet<>();  //HashSet方法
//        while (head1 != null){
//            set.add(head1);
//            head1 = head1.next;
//        }
//        while (head2 != null){
//            if (!set.add(head2))
//                return head2;
//            head2 = head2.next;
//        }

//        Node p1 = head1;  长度不同时，第一遍差值就出来了，第二遍一起到终点
//        Node p2 = head2;
//        while (p1 != p2) {
//            p1 = p1 == null ? head2 : p1.next;
//            p2 = p2 == null ? head1 : p2.next;
//        }

        Node cur1 = head1;
        Node cur2 = head2;
        int len = 0;
        while (cur1 != null) {
            len++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            len--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2)  //如果最后一个节点不同，肯定不相交
            return null;
        cur1 = len > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        len = Math.abs(len);
        while (len != 0) {
            len--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
