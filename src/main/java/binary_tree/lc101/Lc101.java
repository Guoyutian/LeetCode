package binary_tree.lc101;

import binary_tree.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lc101 {
    //recursive
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    //interative
    public boolean isSymmetric_interati(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) return true;
        q.add(root.left);
        q.add(root.right);
        while (q.size() > 1) {
            TreeNode left = q.poll(), right = q.poll();
            if (left == null && right == null) continue;
            if (left == null ^ right == null) return false;
            if (left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
