package linked_list.lc160;

import linked_list.listnode.ListNode;

public class Lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        //
        // Any time they collide or reach end together without colliding
        // then return any one of the pointers.
        //
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            //
            // If one of them reaches the end earlier then reuse it
            // by moving it to the beginning of other list.
            // Once both of them go through reassigning,
            // they will be equidistant from the collision point.
            //
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
