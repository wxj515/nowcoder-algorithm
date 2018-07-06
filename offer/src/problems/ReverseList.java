/**
 * 反转单向和双向链表
 */
package Problems;

public class ReverseList {
    public static class ListNode{
        int val;
        ListNode pre = null;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode reverseList(ListNode head){
        if (head == null)
            return null;

        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode reverseLists(ListNode head){
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
