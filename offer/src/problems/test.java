package problems;

public class test {
    public class Node {
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    Node head = null;
    public void add(int v) {
        Node node = new Node(v);
        if (head == null)
            head = node;
        else {
            Node tmp = head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }

    }

    public static void main(String[] args) {
        test test = new test();

        Node node1 = test.head;
        test.add(1);
        test.add(2);
        test.add(3);
        while (node1 != null) {
            System.out.println(node1.value);
            node1 = node1.next;
        }
    }
}

