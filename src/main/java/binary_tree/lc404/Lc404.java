package binary_tree.lc404;

import binary_tree.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Lc404 {
    //recursive
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }

    //iterative
    public int sumOfLeftLeaves_iter(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null && curr.left.left == null && curr.left.right == null) res += curr.left.val;
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
        return res;
    }
}
