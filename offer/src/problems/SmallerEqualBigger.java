/**
 * 类似荷兰国旗问题：即左边都是小的，中间等于，右边大于
 * 不考虑稳定性：直接创建Node[]存储节点，然后利用荷兰国旗问题求解
 * 考虑稳定性且额外空间O(1)：建三种指针：less，equal，more，分别存储遇到的第一个对应的数
 * 也就是把大链表拆成小链表再连接
 */
package problems;

public class SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null)
            return head;
        Node sh = null, st = null;
        Node eh = null, et = null;
        Node bh = null, bt = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if (sh == null){
                    sh = head;
                    st = head; //这个尾就相当于链表添加函数的辅助节点，只不过是直接存最后一个节点而已
                }else {
                    st.next = head;
                    st = st.next;
                }
            }else if (head.value == pivot){
                if (eh == null){
                    eh = head;
                    et = head;
                }else {
                    et.next = head;
                    et = head;
                }
            }else {
                if (bh == null){
                    bh = head;
                    bt = head;
                }else {
                    bt.next = head;
                    bt = head;
                }
            }
            head = head.next;
        }
        if (st != null){
            st.next = eh;
            et = et == null ? st : et;
        }

        if (et != null){
            et.next = bh;
        }
        if (st != null){
            st.next = eh;
            et = et == null ? st : et;
        }
        if (et != null)
            et.next = bh;
        return sh != null ? sh : eh != null ? eh : bh;
    }
}
