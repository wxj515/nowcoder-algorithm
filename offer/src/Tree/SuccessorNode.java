package Tree;

public class SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null)
            return node;
        Node parent = node.parent;
        if (node.right == null) {
            while (parent != null && parent.left != node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        } else {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }
}
