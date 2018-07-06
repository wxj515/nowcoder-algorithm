package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBSTAndCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBST(Node head) {
        if (head == null)
            return true;
        Stack<Node> stack = new Stack<>();
        int tmp = Integer.MIN_VALUE;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.value < tmp)
                    return false;
                tmp = head.value;
                head = head.right;
            }
        }
        return true;
    }

    public static boolean isCBT(Node head) {
        if (head == null)
            return true;
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (r != null || l != null)) && (r != null && l == null)) {
                return false;
            }
            if (l != null)
                queue.offer(l);
            if (r != null)
                queue.offer(r);
            else
                leaf = true;
        }
        return true;
    }
}
