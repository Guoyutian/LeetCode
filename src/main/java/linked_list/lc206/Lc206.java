package linked_list.lc206;

import linked_list.listnode.ListNode;

public class Lc206 {
    //interative
    public ListNode reverseList_interative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //recursive
    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList_recursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
