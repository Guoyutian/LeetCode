package linked_list.lc21;

import linked_list.listnode.ListNode;

public class Lc21 {
    public ListNode mergeTwoLists_interative(ListNode l1, ListNode l2) {
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1==null)?l2:l1;
        return dummy.next;
    }

    public ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1==null?l2:l1;
        }
        if (l1.val > l2.val) {
            return mergeTwoLists_recursive(l2, l1);
        }
        l1.next = mergeTwoLists_recursive(l1.next, l2);
        return l1;
    }
}
