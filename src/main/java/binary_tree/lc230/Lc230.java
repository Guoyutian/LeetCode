package binary_tree.lc230;

import binary_tree.treenode.TreeNode;

import java.util.Stack;

public class Lc230 {
    //recursive
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
        }
        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }


    //interative
    public int kthSmallest_inter(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);  // Just like recursion
                p = p.left;

            } else {
                TreeNode node = stack.pop();
                if (++count == k) return node.val;
                p = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}
