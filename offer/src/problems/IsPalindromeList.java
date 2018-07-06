/**
 * 判断回文结构：即左右对称，如1,2,2，1
 */
package problems;

import java.util.Stack;

public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    static Node head = null;
    static Node cur = head;
    //need n extra space
    public static boolean isPalindromel(Node head){
        if (head == null || head.next == null)
            return true;

        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur.value);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }

    //need n/2 extra space
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null)
            return true;

        Stack<Integer> stack = new Stack<>();
//        Node slow = head;
//        Node fast = head;
//        while (fast.next != null) {  原本我的写法，但是这种写法会在n为奇数的时候将中位数也加进去多比较一次，有些浪费
//            slow = slow.next;
//            fast = fast.next.next;
//        }
        Node slow = head.next;  //一开始就多跳一位
        Node fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            stack.push(slow.value);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() == head.value)
                head = head.next;
            return false;
        }
        return true;
    }

    //need O(1) extra space
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null)
            return true;

        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null){
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;  //原本可以套在循环里的提出来，原来是为了省掉一个pre=null的过程
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void addNode(int value){
        Node node = new Node(value);
        if (head == null)
            head = node;
        else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    public static void main(String[] args) {
        addNode(1);
        addNode(2);
        addNode(2);
        addNode(2);
        addNode(2);
        addNode(1);
        Node cur = head;
        while (cur != null){
            System.out.println(cur.value);
            cur = cur.next;
        }
        isPalindrome3(head);
    }
}
