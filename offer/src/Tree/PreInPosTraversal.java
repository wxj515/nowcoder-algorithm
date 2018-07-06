package Tree;

import java.util.Stack;

public class PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
     }

     public static void preOrderRecur(Node head) {
        if (head != null) {
            System.out.println(head.value + " ");//先序放这里
            preOrderRecur(head.left);
            //中序这里打印
            preOrderRecur(head.right);
            //后序这里打印
        }
     }

     public static void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
     }

     public static void inOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
     }

    /**
     * 利用先序遍历的思路：首先令存栈顺序小改变为中右左，然后再应该打印的时候存栈，也就是为了使它们的顺序颠倒
     * 变成左右中，最后再完整得打印出第二个栈
     * @param head
     */
     public static void PosOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (head != null) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null)
                    s1.push(head.left);
                if (head.right != null)
                    s1.push(head.right);
            }
            while (!s2.isEmpty())
                System.out.println(s2.pop().value + " ");
        }
     }
}
