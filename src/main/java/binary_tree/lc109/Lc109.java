package binary_tree.lc109;

import binary_tree.treenode.TreeNode;
import linked_list.listnode.ListNode;

public class Lc109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (prev != null) prev.next = null;
        else head = null;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
