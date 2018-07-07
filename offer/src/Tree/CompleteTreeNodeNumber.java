/**
 * 题目：求一棵完全二叉树的节点个数，要求时间复杂度低于O(n)
 * 思路：
 */
package Tree;

public class CompleteTreeNodeNumber {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }

    }

    public static int bs(Node node, int l, int h) {
        if (mostLeftLevel(node.right, l + 1) == h) {
            return (1 << (h - l)) + bs(node.right, l + 1, h);
        } else {
            mostLeftLevel(node.left, )
        }
    }

//    public static int mostLeftLevel(Node node, int level) {
//        while (node != null) {
//            level++;
//            node = node.left;
//        }
//        return level - 1;
//    }
}
