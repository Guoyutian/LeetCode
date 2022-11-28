package binary_tree.lc617;

import binary_tree.treenode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Lc617 {
    // Method 1: Recursive Solution
    // Time: O(n)
    // Space: O(height)
    public TreeNode mergeTrees_recuri(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 != null) {
            t1.val += t2.val;
            t1.left = mergeTrees_recuri(t1.left, t2.left);
            t1.right = mergeTrees_recuri(t1.right, t2.right);
        }

        return t1;
    }

    // Method 2: Iterative DFS
    // Time: O(n)
    // Space: O(height)
    public TreeNode mergeTrees_itera(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        // Use stack to help DFS
        Deque<TreeNode[]> stack = new LinkedList<>();
        stack.offerLast(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] cur = stack.pollLast();
            // no need to merge t2 into t1
            if (cur[1] == null) {
                continue;
            }
            // merge t1 and t2
            cur[0].val += cur[1].val;
            // if node in t1 == null, use node in t2 instead
            // else put both nodes in stack to merge
            if (cur[0].left == null) {
                cur[0].left = cur[1].left;
            } else {
                stack.offerLast(new TreeNode[]{cur[0].left, cur[1].left});
            }
            if (cur[0].right == null) {
                cur[0].right = cur[1].right;
            } else {
                stack.offerLast(new TreeNode[]{cur[0].right, cur[1].right});
            }
        }
        return t1;
    }

    // Method 3: Iterative BFS
    // Time: O(n)
    // Space: O(n)
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        // Use stack to help DFS
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{t1, t2});
        while (!queue.isEmpty()) {
            TreeNode[] cur = queue.poll();
            // no need to merge t2 into t1
            if (cur[1] == null) {
                continue;
            }
            // merge t1 and t2
            cur[0].val += cur[1].val;
            // if node in t1 == null, use node in t2 instead
            // else put both nodes in stack to merge
            if (cur[0].left == null) {
                cur[0].left = cur[1].left;
            } else {
                queue.offer(new TreeNode[]{cur[0].left, cur[1].left});
            }
            if (cur[0].right == null) {
                cur[0].right = cur[1].right;
            } else {
                queue.offer(new TreeNode[]{cur[0].right, cur[1].right});
            }
        }
        return t1;
    }
}
