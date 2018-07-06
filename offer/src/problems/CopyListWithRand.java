/**
 * 复制复杂链表：比传统单链表多了一个指针rand，rand可能指向任意一个节点
 * 解法1：直接hashmap
 * 解法2：在原链表每个节点的next存储copynode，最后分离出来
 */
package problems;

import java.util.HashMap;

public class CopyListWithRand {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }
    //use hashMap
    public static Node copyListWithRand1(Node head) {
        if (head == null)
            return head;

        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
    //
    public static Node copyListWithRand2(Node head) {
        if (head == null)
            return head;

        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
        }
        cur = head;
        while (cur != null) {
            cur.next.rand = cur.rand == null ? null : cur.rand.next;
            cur = cur.next.next;
        }
        cur = head;
        Node res = head.next;
        //split分离
        while (cur != null) {  //exmple:1->1'->2->2'->null
            next = cur.next.next;  //keep 2
            cur.next.next = next == null ? null : next.next; //set 1'->2'
            cur.next = next;        //set 1->2
            cur = cur.next;
        }
        return res;
    }
}
