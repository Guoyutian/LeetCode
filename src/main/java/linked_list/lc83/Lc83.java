package linked_list.lc83;

import linked_list.listnode.ListNode;

public class Lc83 {
    //interative
    public ListNode deleteDuplicates_interative(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = head;
        while(dummy.next != null){
            if(dummy.next.val == dummy.val){
                dummy.next = dummy.next.next;
            }else dummy = dummy.next;
        }
        return head;
    }

    //recursive
    public ListNode deleteDuplicates_recursive(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates_recursive(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
