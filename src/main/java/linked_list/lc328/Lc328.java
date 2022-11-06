package linked_list.lc328;

import linked_list.listnode.ListNode;

public class Lc328 {
    //
    public ListNode oddEvenList(ListNode head) {
        if(head == null|| head.next == null) {
            return head;      //base cases, if we only have 0 or 1 value.
        }
        ListNode temp = head;
        ListNode odd = temp, even = temp.next;       //initialize pointers
        ListNode oddHead = odd, evenHead = even;     //we'll use these at the end
        temp = temp.next.next;      //let's start from the third now.
        int count = 1;      //it's 1-based indexing not 0.
        while(temp != null) {
            if(count % 2 == 0) {         //for even indices
                even.next = temp;
                even = even.next;
            }
            else{                  //for odd indices
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;    //move to the next value.
            count++;
        }
        even.next = null;  //add null after the last value.
        odd.next = evenHead;   //place even stuff after the odd ones.
        return oddHead;
    }

    //two pointer
    public ListNode oddEvenList2(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
